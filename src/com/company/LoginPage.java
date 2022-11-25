package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage extends Window implements ActionListener{


    ImageButton loginButton = new ImageButton("Login","C:/Users/Szilard/Desktop/MAN/pngegg3.png");
    ImageButton resetButton = new ImageButton("Reset","C:/Users/Szilard/Desktop/MAN/pngegg3.png");

    ImageButton b3 = new ImageButton("User","C:/Users/Szilard/Desktop/MAN/pngegg4.png");
    ImageButton b4 = new ImageButton("Password","C:/Users/Szilard/Desktop/MAN/pngegg4.png");



    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel messageLabel = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    boolean Successfull= false;

    LoginPage(HashMap<String,String> loginInfoOriginal){
        contentPane = (JPanel) getContentPane();
        //setStart
        setVisible(true);
        logininfo = loginInfoOriginal;
        Font font1 = new Font("SansSerif", Font.BOLD, 40);

        Background panel = new Background(new ImageIcon("C:/Users/Szilard/Desktop/MAN/logo.jpg").getImage());
        BackgroundForButtons panelForButtons = new BackgroundForButtons(new ImageIcon("C:/Users/Szilard/Desktop/MAN/ForButtons.png").getImage());


        Dimension Buttonsize = new Dimension(super.getWidth()/4,80);

        loginButton.setSize(Buttonsize);
        resetButton.setSize(Buttonsize);
        b3.setSize((int)Buttonsize.getWidth()/2,(int)Buttonsize.getHeight());
        b4.setSize((int)Buttonsize.getWidth()/2,(int)Buttonsize.getHeight());


        userIDField.setFont(font1);
        userIDField.setBounds(getWidth()/2-100,getHeight()/2-3*(int)Buttonsize.getHeight()+5,(int)Buttonsize.getWidth(),(int)Buttonsize.getHeight());
        userIDField.setSize((int)Buttonsize.getWidth()-50,(int)Buttonsize.getHeight()-20);

        userPasswordField.setFont(font1);
        userPasswordField.setBounds(getWidth()/2-100,getHeight()/2-2*(int)Buttonsize.getHeight()+10,(int)Buttonsize.getWidth(),(int)Buttonsize.getHeight());
        userPasswordField.setSize((int)Buttonsize.getWidth()-50,(int)Buttonsize.getHeight()-20);

        loginButton.setLocation(getWidth()/2,super.getHeight()/2+(int)Buttonsize.getHeight()*1/3);
        resetButton.setLocation(getWidth()/2-(int)Buttonsize.getWidth(),super.getHeight()/2+(int)Buttonsize.getHeight()*1/3);

        b3.setLocation(getWidth()/2-(int)Buttonsize.getWidth()/2-b3.getWidth()/2,super.getHeight()/2-3*(int)Buttonsize.getHeight()-10);
        b4.setLocation(getWidth()/2-(int)Buttonsize.getWidth()/2-b4.getWidth()/2,super.getHeight()/2-2*(int)Buttonsize.getHeight());








        //loginButton.addActionListener(this);


        contentPane.add(loginButton);
        contentPane.add(resetButton);
        contentPane.add(b3);
        contentPane.add(b4);


        //  contentPane.add(userIDLabel);
      //  contentPane.add(userPasswordLabel);
      //  contentPane.add(messageLabel);
      //  contentPane.add(userIDField);
        contentPane.add(userPasswordField);
        contentPane.add(userIDField);
        contentPane.add(loginButton);
        contentPane.add(resetButton);

        contentPane.setLayout(null);
        contentPane.setVisible(true);
      //  contentPane.setBackground(Color.LIGHT_GRAY);
        panelForButtons.setPosition(getWidth()/2-super.getWidth()/4);
        panelForButtons.setLenght(getWidth()/2);
        contentPane.add(panelForButtons);
        contentPane.add(panel);

    }








    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()==loginButton) {
            CheckPassword();
        }
    }
    public void CheckPassword(){
        String userID = userIDField.getText();
        String Password = String.valueOf(userPasswordField.getPassword());

        if(logininfo.containsKey(userID)) {
            if(logininfo.get(userID).equals(Password)) {
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Login successful");
                Successfull=true;
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong password");
            }
        }
        else {
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Username not found");
        }
    }
    public boolean check(){
        return Successfull;
    }
    public void setActivity(boolean state) {
        setVisible(state);
    }
    public void doAction(Context context) {
        System.out.println("Player is in Login");
        context.setState(this);
    }
    public String toString() {

        return "Login";
    }
}