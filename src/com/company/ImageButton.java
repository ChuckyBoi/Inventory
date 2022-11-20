package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageButton extends JButton {

    Image image;
    String text;

    public ImageButton(String text){
        this.text= text;
        try {
            image = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/pngegg3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        // b1.setFocusPainted(false);

    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);

        write(g,text);

    }


    public void write(Graphics g,String text) {
        Font font = new Font("Garamond", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.YELLOW);
        FontMetrics metrics = g.getFontMetrics(font);
        int positionX = (image.getWidth(this) - metrics.stringWidth(text)) / 2;
        int positionY = (image.getHeight(this)- metrics.getHeight()) / 2 + metrics.getAscent();
        g.drawString(text, positionX, positionY);


    }


}
