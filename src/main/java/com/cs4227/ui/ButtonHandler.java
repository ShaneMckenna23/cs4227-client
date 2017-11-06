package com.cs4227.ui;

import com.cs4227.ui.components.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonHandler implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        Button btn = (Button) e.getSource();
        btn.onClick();
    }
}