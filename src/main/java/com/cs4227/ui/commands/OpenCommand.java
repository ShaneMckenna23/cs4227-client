package com.cs4227.ui.commands;

import com.cs4227.ui.components.ImageOpener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OpenCommand implements Command {

    @Override
    public void execute() {
        JFrame frame = new ImageOpener();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void undo() {

    }
}
