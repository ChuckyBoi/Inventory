package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class ImageButton extends JButton {

    Image image;
    String text;
    boolean mouseEntered=false;
    FontMetrics metrics;

    public ImageButton(String text){
        this.text= text;
        try {
            image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/pngegg3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(true);
        setBorder(new LineBorder(Color.BLACK,50));
        // b1.setFocusPainted(false);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);


        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEntered=true;
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(UIManager.getColor("control"));
                mouseEntered=false;
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // setBackground(Color.black);
            }

        });


        write(g,text);



    }


    public void write(Graphics g,String text) {
        Font font = new Font("Garamond", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.YELLOW);
        FontMetrics metrics = g.getFontMetrics(font);

        int positionX = (image.getWidth(this) - metrics.stringWidth(text)) / 2;
        int positionY = (image.getHeight(this)- metrics.getHeight()) / 2 + metrics.getAscent();
        if(mouseEntered)
        {
            positionX+=5;
            positionY+=5;
        }
        else{
            positionX-=0;
            positionY-=0;
        }

        g.drawString(text, positionX, positionY);


    }
    public void action(){
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(UIManager.getColor("control"));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               // setBackground(Color.black);
            }

        });
    }

}
