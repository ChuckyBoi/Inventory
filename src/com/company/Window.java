package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Window extends JFrame implements  State{

    public static int WIDTH = 1920, HEIGHT = 1080;

    JPanel contentPane;

    public Window() {


        setSize(WIDTH, HEIGHT);
        setTitle("vettel my ");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);



    }



}
