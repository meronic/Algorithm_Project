package com.company;

import javax.swing.*;

public class Text_Area extends JTextArea {

    public Text_Area(){
        setColumns(30);
        setRows(13);
        setEditable(false);
        setLineWrap(true);
    }

}
