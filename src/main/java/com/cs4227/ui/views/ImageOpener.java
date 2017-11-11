package com.cs4227.ui.views;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.framework.visitor.ImageValueProcessor;
import com.cs4227.ui.Start;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageOpener extends JFrame {

    public ImageOpener(){
        super("Choose an Image");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JFileChooser fileChooser = new JFileChooser("C://Users");
        fileChooser.setControlButtonsAreShown(true);
        fileChooser.setDialogType(fileChooser.OPEN_DIALOG);

        add(fileChooser, BorderLayout.CENTER);
        this.pack();
    }
}
