package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Window extends JFrame implements  State{



    JPanel contentPane;

    public Window() {


        Dimension size = getToolkit().getScreenSize();
        setSize(size);
        setTitle("vettel my ");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);



    }



}
