package com.cs4227.ui.components;

import com.cs4227.ui.views.ImageView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver extends JFrame {

    public ImageSaver() {
        super("Choose an Image");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setControlButtonsAreShown(true);
        fileChooser.setDialogType(fileChooser.SAVE_DIALOG);

        add(fileChooser, BorderLayout.CENTER);

//  Create ActionListener
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();

                String command = actionEvent.getActionCommand();

                if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                    File fileDestination = theFileChooser.getSelectedFile();
                    String path = fileDestination.getParent()+"\\"+fileDestination.getName();
                    File file = new File(path);

                    BufferedImage image = ImageView.selectedImage;
                    try{
                        ImageIO.write(image, "jpg", file);
                    }catch (Exception e){

                    }
                    dispose();
                } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                    dispose();
                }
            }
        };
        fileChooser.addActionListener(actionListener);


        // pack();
        setVisible(true);
    }
}
