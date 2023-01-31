package com.company;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends Window{

    //Image img = Toolkit.getDefaultToolkit().createImage("C:/Users/Szilard/Desktop/MAN/stadium.jpg");


    ImageButton b1 = new ImageButton("Produse","C:/Users/Szilard/Desktop/MAN/button.png");
    ImageButton b2 = new ImageButton("Alright","C:/Users/Szilard/Desktop/MAN/button_2.png");
    ImageButton b3 = new ImageButton("Options","C:/Users/Szilard/Desktop/MAN/button_3.png");
    ImageButton b4 = new ImageButton("Button4","C:/Users/Szilard/Desktop/MAN/button_4.png");
    ImageButton b5 = new ImageButton("Button5","C:/Users/Szilard/Desktop/MAN/button_5.png");

  //  ImageButton Exit = new ImageButton("Exit","C:/Users/Szilard/Desktop/MAN/pngegg4.png");


    Icon icon = new ImageIcon("C:/Users/Szilard/Desktop/MAN/stop2.png");
    JButton Music = new JButton(icon);

    Background panel = new Background(new ImageIcon("C:/Users/Szilard/Desktop/MAN/SDA1.png").getImage());
  //  BackgroundForButtons panelForButtons = new BackgroundForButtons(new ImageIcon("C:/Users/Szilard/Desktop/MAN/ForButtons.png").getImage());

    public MainMenu()
    {
        setup();
    }


    public void setup() {

        Dimension Buttonsize = new Dimension(super.getWidth()/4,80);

        setTitle("Main Menu");

        contentPane = (JPanel)getContentPane();
        contentPane.setLayout(null);
       // contentPane.setLayout(new BorderLayout());
       // add(panel);


      //  b1.setBorder(new RoundedBorder(20)); //10 is the radius
      //  b2.setBorder(new RoundedBorder(20)); //10 is the radius
      //  b3.setBorder(new RoundedBorder(20)); //10 is the radius

        b1.setSize(b1.getSizeX(),b1.getSizeY());
        b2.setSize(b2.getSizeX(),b2.getSizeY());
        b3.setSize(b3.getSizeX(),b3.getSizeY());
        b4.setSize(b4.getSizeX(),b4.getSizeY());
        b5.setSize(b5.getSizeX(),b5.getSizeY());

        //   Exit.setSize((int)Buttonsize.getWidth()/2,(int)Buttonsize.getHeight());

        Music.setSize(60,60);

        b1.setLocation(super.getWidth()/2-b1.getSizeX()/2,super.getHeight()/2-5*b1.getSizeY()/2-30);

        b2.setLocation(super.getWidth()/2-b2.getSizeX()/2,super.getHeight()/2-3*b2.getSizeY()/2-15);

        b3.setLocation(super.getWidth()/2-b3.getSizeX()/2,super.getHeight()/2-1*b3.getSizeY()/2);

        b4.setLocation(super.getWidth()/2-b4.getSizeX()/2,super.getHeight()/2+1*b3.getSizeY()/2+15);

        b5.setLocation(super.getWidth()/2-b5.getSizeX()/2,super.getHeight()/2+3*b3.getSizeY()/2+30);

        // Exit.setLocation(super.getWidth()/4-(int)Exit.getWidth()/2,super.getHeight()/2-(int)Exit.getHeight()*1/3);

        Music.setLocation(super.getWidth()-(int)Music.getSize().getWidth()*3/2,Music.getHeight()/4);

        //b1.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
      //  b2.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));
      //  b3.setFont(new java.awt.Font("Garamond", Font.PLAIN, 70));


        b1.setForeground(Color.black);
        b2.setForeground(Color.black);
        b3.setForeground(Color.black);
        b4.setForeground(Color.black);
        b5.setForeground(Color.black);



        //contentPane.add(a);


       contentPane.add(b1);
       contentPane.add(b2);
       contentPane.add(b3);
       contentPane.add(b4);
       contentPane.add(b5);

        //contentPane.add(Exit);
       contentPane.add(Music);

       // panelForButtons.setLenght(b1.getWidth());
      // panelForButtons.setPosX(getToolkit().getScreenSize().width/4-b1.getWidth()/2);
       // contentPane.add(panelForButtons);
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
        System.out.println("Player is in Main Menu");
        context.setState(this);
    }

    public void setActivity(boolean state)
    {
        setVisible(state);
    }

    public String toString() {
        return "Main Menu";
    }


}











