package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

public class Option extends Window{

    JButton b1 = new JButton("Man united");
    JButton b2 = new JButton("Cristiano ");
    JButton b3 = new JButton("Harry Maguire");



    public Option() {
        setup();
    }

    public void setup() {

        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        setTitle("ALONSO");

        Dimension Buttonsize = new Dimension(super.getWidth()/4,80);


        b1.setBorder(new RoundedBorder(40)); //10 is the radius

        b1.setForeground(Color.BLUE);

        b1.setSize(Buttonsize);
        b2.setSize(Buttonsize);
        b3.setSize(Buttonsize);



        b1.setLocation(super.getWidth()/2-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*3/3);
        b2.setLocation(super.getWidth()/2-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*7/3);
        b3.setLocation(super.getWidth()/2-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*11/3);


        b1.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b2.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b3.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));

        b1.setForeground(Color.black);
        b2.setForeground(Color.black);
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











