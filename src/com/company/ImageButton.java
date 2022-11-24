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

    int sizeX=0,sizeY=0;


    public ImageButton(String text,String path){
        this.text= text;
        try {
            image = ImageIO.read(new File(path));
            sizeX=image.getWidth(this);
            sizeY=image.getHeight(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(true);
        setContentAreaFilled(false);
        setBorderPainted(true);
        setBorder(new LineBorder(Color.BLACK,10));
        // b1.setFocusPainted(false);

    }

    public void paint(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

                if (sizeX > 600) {
                    try {
                        image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/ButtonWithBorder2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //set outline stroke too
                } else {
                    try {
                        image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/SmallButtonWithBorder.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (sizeX > 600) {
                    try {
                        image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/pngegg3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //set outline stroke too
                } else {
                    try {
                        image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/pngegg4.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
               mouseEntered=true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseEntered=false;
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
}
