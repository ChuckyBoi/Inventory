package com.company;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StateManager{

    Options options = new Options();
    MainMenu MainMenu = new MainMenu();
    Produse Produse = new Produse();

    Context context = new Context();//Use the Context to see change in behaviour when State changes.

    IDandPasswords idandPasswords = new IDandPasswords();
    LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
    PlayMusic audioPlayer = new PlayMusic("C:/Users/Szilard/Desktop/MAN/manU.wav");

    boolean startMusic=false;


    public void run() {

        // p.play();
        audioPlayer.play();
        audioPlayer.pause();
        //make it so you dont use a.b1. ...


        Produse.viewData();

        Produse.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                   if(column==1){
                       Produse.showImage( row);

                   }
                    if(column==7){
                        System.out.println("substract");
                      //  Produse.substract(row);

                    }

                }
            }
        });


        Produse.back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.doAction(context);
                Check();
            }
        });
        MainMenu.b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Produse.doAction(context);
                Check();
            }
        });

        options.b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                MainMenu.doAction(context);
                Check();
            }
        });
        MainMenu.b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                options.doAction(context);
                Check();
            }
        });
        MainMenu.Music.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (audioPlayer.status.equals("play")) {
                    audioPlayer.pause();
                } else {
                    audioPlayer.play();
                }
            }
        });

        loginPage.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginPage.loginButton) {
                    loginPage.CheckPassword();
                    if (loginPage.check()) {
                        loginPage.doAction(context);
                        Check();
                    }
                }
                if (e.getSource() == loginPage.resetButton) {
                    loginPage.userIDField.setText("");
                    loginPage.userPasswordField.setText("");
                }
            }
        });
        loginPage.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginPage.resetButton) {
                    loginPage.userIDField.setText("");
                    loginPage.userPasswordField.setText("");
                }
            }


        });
        loginPage.linkAction();
    }


   public void Check(){
       try {
           if(context.getState().toString().equals("Login")){
               loginPage.setActivity(false);
               MainMenu.setActivity(true);
           }
           if (context.getState().toString().equals("Options")) {
               options.setActivity(true);
               MainMenu.setActivity(false);

           }
           if (context.getState().toString().equals("Main Menu")) {
               MainMenu.setActivity(true);
               options.setActivity(false);
           }
           if (context.getState().toString().equals("Produse")) {
               MainMenu.setActivity(false);
               Produse.viewData();
               Produse.setActivity(true);
           }

       }
       catch(NullPointerException e)
       { }

   }




}

