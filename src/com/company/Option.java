package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.border.Border;
import javax.swing.AbstractButton;

public class Option extends Window{

    //Image img = Toolkit.getDefaultToolkit().createImage("C:/Users/Szilard/Desktop/MAN/stadium.jpg");


    ImageButton b1 = new ImageButton("Man United","C:/Users/Szilard/Desktop/MAN/pngegg3.png");
    ImageButton b2 = new ImageButton("Cristiano ","C:/Users/Szilard/Desktop/MAN/pngegg3.png");
    ImageButton b3 = new ImageButton("Harry","C:/Users/Szilard/Desktop/MAN/pngegg3.png");
    ImageButton Exit = new ImageButton("Exit","C:/Users/Szilard/Desktop/MAN/pngegg4.png");





    Icon icon = new ImageIcon("C:/Users/Szilard/Desktop/MAN/stop2.png");
    JButton Music = new JButton(icon);

    Background panel = new Background(new ImageIcon("C:/Users/Szilard/Desktop/MAN/logo.jpg").getImage());
    BackgroundForButtons panelForButtons = new BackgroundForButtons(new ImageIcon("C:/Users/Szilard/Desktop/MAN/ForButtons.png").getImage());




    public Option()
    {
        setup();
    }


    public void setup() {

        Dimension Buttonsize = new Dimension(super.getWidth()/4,80);

        setTitle("ALONSO");

        contentPane = (JPanel)getContentPane();
        contentPane.setLayout(null);
       // contentPane.setLayout(new BorderLayout());
       // add(panel);




      //  b1.setBorder(new RoundedBorder(20)); //10 is the radius
      //  b2.setBorder(new RoundedBorder(20)); //10 is the radius
      //  b3.setBorder(new RoundedBorder(20)); //10 is the radius


        b1.setSize(Buttonsize);
        b2.setSize(Buttonsize);
        b3.setSize(Buttonsize);

        Exit.setSize((int)Buttonsize.getWidth()/2,(int)Buttonsize.getHeight());

        Music.setSize(60,60);



        b1.setLocation(super.getWidth()/4-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*13/3);
        b2.setLocation(super.getWidth()/4-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*9/3);
        b3.setLocation(super.getWidth()/4-(int)Buttonsize.getWidth()/2,super.getHeight()/2-(int)Buttonsize.getHeight()*5/3);
        Exit.setLocation(super.getWidth()/4-(int)Exit.getWidth()/2,super.getHeight()/2-(int)Exit.getHeight()*1/3);



        Music.setLocation(super.getWidth()-(int)Music.getSize().getWidth()*3/2,Music.getHeight()/4);

        //b1.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
      //  b2.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
      //  b3.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));


        b1.setForeground(Color.black);
        b2.setForeground(Color.black);
        b3.setForeground(Color.black);


        //contentPane.add(a);


       contentPane.add(b1);
       contentPane.add(b2);
       contentPane.add(b3);
       contentPane.add(Exit);
       contentPane.add(Music);

        panelForButtons.setLenght(b1.getWidth());
       panelForButtons.setPosition(getToolkit().getScreenSize().width/4-b1.getWidth()/2);
        contentPane.add(panelForButtons);
        contentPane.add(panel);




    //b1.setPos(b1.getBounds().x,b1.getBounds().y);
   // b2.setPos(b2.getBounds().x,b2.getBounds().y);
   // b3.setPos(b3.getBounds().x,b3.getBounds().y);



    }

    public void draw(Graphics g) {
      //  super.paintComponent(g);
       // super.paint(g);

       // b1.draw(g);
      //  b2.draw(g);
      // b3.draw(g);
      //  panel.draw(g);


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











