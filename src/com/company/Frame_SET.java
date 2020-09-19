package com.company;

import javax.swing.*;

public class Frame_SET extends JFrame{

    public Frame_SET(){
        setTitle("project program");


        add(new Panel());

        pack();
        setLocationRelativeTo(null);
        setSize(400,450);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}