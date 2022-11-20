package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.border.Border;
import javax.swing.AbstractButton;

public class Option extends Window{

    ImageButton b1 = new ImageButton("Man United");
    ImageButton b2 = new ImageButton("Cristiano ");
    ImageButton b3 = new ImageButton("Harry");
    Icon icon = new ImageIcon("C:/Users/Szilard/Desktop/MAN/stop2.png");
    JButton b4 = new JButton(icon);

    //add a C here



    public Option() {
        setup();
    }

    public void setup() {


            ImageIcon image =  new ImageIcon("C:/Users/Szilard/Desktop/MAN/stadium.jpg");
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);





        // b4.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        //b4.setForeground(Color.black);

        setTitle("ALONSO");

        Dimension Buttonsize = new Dimension(super.getWidth()/4,80);


        b1.setBorder(new RoundedBorder(20)); //10 is the radius
        b2.setBorder(new RoundedBorder(20)); //10 is the radius
        b3.setBorder(new RoundedBorder(20)); //10 is the radius



        b1.setSize(Buttonsize);
        b2.setSize(Buttonsize);
        b3.setSize(Buttonsize);
        b4.setSize(60,60);



        b1.setLocation(super.getWidth()/2-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*3/3);
        b2.setLocation(super.getWidth()/2-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*7/3);
        b3.setLocation(super.getWidth()/2-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*11/3);

        b4.setLocation(super.getWidth()-(int)b4.getSize().getWidth()*3/2,b4.getHeight()/4);


        b1.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b2.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
        b3.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));

        b1.setText("sdadasdas");

        b1.setForeground(Color.black);
        b2.setForeground(Color.black);
        b3.setForeground(Color.black);

        contentPane.add(b4);
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











