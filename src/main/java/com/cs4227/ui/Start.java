package com.cs4227.ui;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.ui.views.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.InputStream;


public class Start {

    public static void main(String[] args) throws Exception {
        InputStream in = Start.class.getResourceAsStream("/imageDefault.jpg");
        BufferedImage selectedImage = ImageIO.read(in);

        ImageView imageView = new ImageView(selectedImage);
        OptionsView optionsView = new OptionsView();

        AdjustmentsView adjustmentsView = new AdjustmentsView();
        TransformView transformView = new TransformView();

        EditorController editorController = new EditorController(imageView,optionsView);

        imageView.setVisible(true);
        optionsView.setVisible(true);
        adjustmentsView.setVisible(true);
        transformView.setVisible(true);
    }


    public static void modifyImage(BufferedImage image) throws Exception {

        MementoControl.originator.set( image );
        MementoControl.caretaker.addMemento( MementoControl.originator.storeInMemento() );

        MementoControl.setImagePathCount( MementoControl.getImageCount() + 1 );
        MementoControl.setCurrentPathIndex( MementoControl.getCurrentPathIndex() + 1 );

        refreshImage(image, image.getWidth(), image.getHeight());
    }

    public static void refreshImage (BufferedImage image, int w, int h) throws Exception {


    }
}
