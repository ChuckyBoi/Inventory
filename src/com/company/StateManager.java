package com.company;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class StateManager{

    Application a = new Application();
    Option o = new Option();
    Context context = new Context();//Use the Context to see change in behaviour when State changes.

    IDandPasswords idandPasswords = new IDandPasswords();
    LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
    //PlayMusic p = new PlayMusic();




    public void run(){

       // p.play();
        //make it so you dont use a.b1. ...
          a.b1.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  o.doAction(context);
                  Check();
              }
          });
        o.b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.doAction(context);
                Check();
            }
        });
        loginPage.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==loginPage.loginButton) {
                    loginPage.CheckPassword();
                    if(loginPage.check()){
                        loginPage.doAction(context);
                        Check();
                    }
                }
            }
        });
      }


   public void Check(){
       try {
           if(context.getState().toString().equals("Login")){
               loginPage.setActivity(false);
               a.setActivity(true);
           }
           if (context.getState().toString().equals("Options")) {
               a.setActivity(false);
               o.setActivity(true);
           }
           if (context.getState().toString().equals("Main menu")) {
               o.setActivity(false);
               a.setActivity(true);
           }

       }
       catch(NullPointerException e)
       { }

   }




}

