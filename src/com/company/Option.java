package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Option extends Window{

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();

    public Option() {
        setup();
    }

    public void setup() {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        setTitle("ALONSO");

        b1.setText("back");
        b1.setSize(300,100);
       // b1.setBounds(getSize().width/2- b1.getSize().width/2 ,contentPane.getY()/2,300, 100);
        b1.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b1.setForeground(Color.black);

        b2.setText("am");
        b2.setSize(300,100);
        // b1.setBounds(getSize().width/2- b1.getSize().width/2 ,contentPane.getY()/2,300, 100);
        b1.setBounds(300,300,300,100);
        b2.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b2.setForeground(Color.black);

        b3.setText("kewl");
        b3.setSize(300,100);
        b3.setBounds(900,300,300,100);
        // b1.setBounds(getSize().width/2- b1.getSize().width/2 ,contentPane.getY()/2,300, 100);
        b3.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b3.setForeground(Color.black);



        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
    }

    public void doAction(Context context) {
        System.out.println("Player is in Options");
        context.setState(this);
    }
    public void setActivity(boolean state) {
        setVisible(state);
    }

    public String toString() {
        return "Options";
    }
}











