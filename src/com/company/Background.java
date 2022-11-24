package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


    class Background extends JPanel {
        private Image img;

        public Background(String img) {
            this(new ImageIcon(img).getImage());
        }

        public Background(Image img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(getToolkit().getScreenSize());
            setLayout(null);
        }

        public void paint(Graphics g) {
           // super.paintComponent(g);

            int width = this.getSize().width;
            int height = this.getSize().height;
            if (this.img != null) {
                //Add the size of the window in drawImage method()
               // g.drawImage(this.background, 0, 0, width, height, null);
                g.drawImage(img, 0, 0,width,height ,null);
            }
        }
    }


