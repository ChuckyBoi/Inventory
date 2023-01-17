package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
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
    String path;

    int sizeX=0;
    int sizeY=0;

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }



    public ImageButton(String text,String path){
        this.path=path;
        this.text= text;
        try {
            image = ImageIO.read(new File(path));
            sizeX=image.getWidth(this)-100;
            sizeY=image.getHeight(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(true);
        setContentAreaFilled(false);
        setBorderPainted(true);
        // b1.setFocusPainted(false);

    }

    public void paint(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, image.getWidth(this),image.getHeight(this),null);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

                 if(sizeX<320) {
                     try {
                         image = ImageIO.read(new File("C:/Users/user/IdeaProjects/Inventory/LoginActive.png"));
                         // image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/ButtonWithBorder2.png"));
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }

                if(sizeX>710) {

                    if (text.equals("Button1")) {
                        try {
                            image = ImageIO.read(new File("C:/Users/user/IdeaProjects/Inventory/button_active.png"));
                            // image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/ButtonWithBorder2.png"));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (text.equals("Button2")) {
                        try {
                            image = ImageIO.read(new File("C:/Users/user/IdeaProjects/Inventory/button_2_active.png"));
                            // image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/ButtonWithBorder2.png"));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if (text.equals("Button3")) {
                        try {
                            image = ImageIO.read(new File("C:/Users/user/IdeaProjects/Inventory/button_3_active.png"));
                            // image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/ButtonWithBorder2.png"));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if (text.equals("Button4")) {
                        try {
                            image = ImageIO.read(new File("C:/Users/user/IdeaProjects/Inventory/button_4_active.png"));
                            // image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/ButtonWithBorder2.png"));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }if (text.equals("Button5")) {
                        try {
                            image = ImageIO.read(new File("C:/Users/user/IdeaProjects/Inventory/button_5_active.png"));
                            // image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/ButtonWithBorder2.png"));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

                    //set outline stroke too

            }


          public void mouseExited(java.awt.event.MouseEvent evt) {



                try {
                    image = ImageIO.read(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }



                    //set outline stroke too



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

        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:/Users/user/IdeaProjects/Inventory/Orbitron.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(customFont);
            FontMetrics metrics = g.getFontMetrics(customFont);

            g.setColor(Color.WHITE);
            g.setFont(customFont);

            int positionX = (sizeX - metrics.stringWidth(text)) / 2;
            int positionY = (sizeY- metrics.getHeight()) / 2 + metrics.getAscent();
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

        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
    }
}
