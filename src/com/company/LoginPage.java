package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage extends Window implements ActionListener{


    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    HashMap<String,String> logininfo = new HashMap<String,String>();

    boolean Successfull= false;

    LoginPage(HashMap<String,String> loginInfoOriginal){
        contentPane = (JPanel) getContentPane();
        setVisible(true);

        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(260,250,75,25);
        userPasswordLabel.setBounds(260,300,75,25);

        messageLabel.setBounds(340,400,250,35);
        //messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(340,250,200,25);
        userPasswordField.setBounds(340,300,200,25);

        loginButton.setBounds(405,350,100,25);
        contentPane.setLayout( new GridBagLayout() );

        loginButton.setFocusable(true);
        loginButton.addActionListener(this);

        resetButton.setBounds(295,350,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        contentPane.add(userIDLabel);
        contentPane.add(userPasswordLabel);
        contentPane.add(messageLabel);
        contentPane.add(userIDField);
        contentPane.add(userPasswordField);
        contentPane.add(loginButton);
        contentPane.add(resetButton);

        contentPane.setLayout(null);
        contentPane.setVisible(true);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setSize(820,700);
        super.setSize(820,700);
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