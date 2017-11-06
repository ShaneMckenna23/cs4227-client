package com.cs4227.ui.components;

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

//  Create ActionListener
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();

                String command = actionEvent.getActionCommand();

                if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                    File selectedFile = theFileChooser.getSelectedFile();
                    try {
                        BufferedImage selectedImage = ImageIO.read(selectedFile);

                        //Put Image into frame
                        int width = selectedImage.getWidth();
                        int height = selectedImage.getHeight();
                        Start.refreshImage(selectedImage, width, height);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    dispose();
                } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                    dispose();
                }
            }
        };
        fileChooser.addActionListener(actionListener);

       setVisible(true);
    }
}
