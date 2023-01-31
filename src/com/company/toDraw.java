package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class toDraw extends JFrame {

    JPanel contentPane;

    public  void drawing() throws IOException {

        setTitle("image");
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        setLocation(200,200);
        // setSize(300,300);
        setVisible(true);


        try {
            //  Image theImage = ImageIO.read(new File("C:/Users/Szilard/Desktop/Grove Street/image2/bell.png"));
            BufferedImage myPicture = ImageIO.read(new File("C:/Users/Szilard/Desktop/MAN/idk.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            setSize(myPicture.getWidth(),myPicture.getHeight()+100);
            //fix making it content pane size and not only window size,thus no full pic
            picLabel.setBounds(0,0,myPicture.getWidth(),myPicture.getHeight());
            contentPane.add(picLabel);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }







    }


}
