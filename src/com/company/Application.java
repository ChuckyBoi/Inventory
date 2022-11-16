package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class Application extends Window {

    JButton b1 = new JButton();

    public Application() {
        setup();
    }
    public void setup() {

        setActivity(false);
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        setTitle("CHARLES LECLERC");
        b1.setText("Options");
        b1.setSize(300,100);
        b1.setBounds(contentPane.getSize().width/2 - b1.getSize().width/2, contentPane.getSize().height/2 - b1.getSize().height/2, 300, 100);
        b1.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b1.setForeground(Color.black);

        contentPane.setLayout( new GridBagLayout() );
        contentPane.add(b1, new GridBagConstraints());

        contentPane.add(b1);
    }

    public void setActivity(boolean state) {
        setVisible(state);
    }

    public void doAction(Context context) {
        System.out.println("Player is in Main menu");
        context.setState(this);
    }


    public String toString() {
        return "Main menu";
    }

}
