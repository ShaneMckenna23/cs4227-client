package com.cs4227.ui.views;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.framework.visitor.ImageValueProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageView extends JFrame {

    private BufferedImage selectedImage;
    private JLabel imageLabel;
    private ImageIcon image;

    public ImageView(BufferedImage selectedImage) {
        super("Image Viewer");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.setSize(620, 620);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.selectedImage = selectedImage;

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        this.image = new ImageIcon(selectedImage);
        this.imageLabel = new JLabel(this.image);

        //Add the image to the frame
        Container contentPane = getContentPane();
        contentPane.add(imageLabel, BorderLayout.CENTER);
    }

    public BufferedImage getImage(){
        return selectedImage;
    }

    public void setImage(BufferedImage image){

        MementoControl.originator.set( image );
        MementoControl.caretaker.addMemento( MementoControl.originator.storeInMemento() );
        MementoControl.setImagePathCount( MementoControl.getImageCount() + 1 );
        MementoControl.setCurrentPathIndex( MementoControl.getCurrentPathIndex() + 1 );

        //This is just a text output for the visitor
        ImageValueProcessor visitorExample = new ImageValueProcessor(image);

        changeImage(image);
    }

    public void changeImage(BufferedImage image){

        // I'll need this method for the memento
        selectedImage = image;
        imageLabel.setIcon(new ImageIcon(selectedImage));
    }
}
