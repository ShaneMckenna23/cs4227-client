package com.cs4227.ui.commands;

import com.cs4227.ui.views.ImageSaver;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SaveCommand implements Command {

    @Override
    public void execute() {
        JFrame frame = new ImageSaver();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        // frame.setSize(450, 300); // get image size and scale it
        frame.setVisible(true);
    }

    @Override
    public void undo() {

    }
}
