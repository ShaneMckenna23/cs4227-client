package com.cs4227.ui.views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageView extends JFrame {

    public static BufferedImage selectedImage;

    public ImageView(BufferedImage image) {
        super("Image Viewer");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.setSize(620, 620);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        selectedImage = image;

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;


        JLabel actualImage = new JLabel(new ImageIcon(selectedImage));

        //Add the image to the frame
        Container contentPane = getContentPane();
        contentPane.add(actualImage, BorderLayout.CENTER);
    }

    public BufferedImage getImage(){
        return selectedImage;
    }
    public void setImage(BufferedImage image){
        selectedImage = image;

        JLabel actualImage = new JLabel(new ImageIcon(selectedImage));
        //Add the image to the frame
        Container contentPane = getContentPane();
        contentPane.add(actualImage, BorderLayout.CENTER);
    }
}
