package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;


class BackgroundForButtons extends JPanel {
        private Image img;
        Dimension size;
        BufferedImage Bimg;
        int positionX=0;
        int lenght=0;

        public BackgroundForButtons(String img) {

            this(new ImageIcon(img).getImage());
        }

        public BackgroundForButtons(Image img) {
            this.img = img;
             size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(getToolkit().getScreenSize());
            setLayout(null);
        }

        public void setPosX(int x){
            positionX=x;
        }
        public int getPosX(){
         return positionX;
            }

        public void setLenght(int x){
            lenght=x;
        }
        public int returnSize(){
            return lenght;
        }
        public void paint(Graphics g) {
          //  super.paintComponent(g);
            Bimg=setTransparent(img);


            int width = this.getSize().width;
            int height = this.getSize().height;

            int x= (int)size.getWidth();

            if (this.img != null) {
                //Add the size of the window in drawImage method()
                // g.drawImage(this.background, 0, 0, width, height, null);

                //createGraphics.drawImage(img, getToolkit().getScreenSize().width/2-x/2,0,img.getWidth(null),height ,null);

                //POSITION IS SET HERE,FIX
                g.drawImage(Bimg, positionX,0,lenght,height ,null);
            }
        }
    public static BufferedImage setTransparent(Image image)
    {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();

        float opacity = 0.8f;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
    }


