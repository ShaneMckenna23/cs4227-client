package com.cs4227.ui;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.ImageOpener;
import com.cs4227.ui.views.ImageView;
import com.cs4227.ui.views.OptionsView;
import com.cs4227.ui.views.ToolboxView;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.InputStream;


public class Start {

    public static void main(String[] args) throws Exception {
        InputStream in = Start.class.getResourceAsStream("/imageDefault.jpg");
        BufferedImage selectedImage = ImageIO.read(in);

        ImageView imageView = new ImageView(selectedImage);
        OptionsView optionsView = new OptionsView();
        ToolboxView toolboxView = new ToolboxView();
        ImageOpener imageOpener = new ImageOpener();

        EditorController editorController = new EditorController(imageView,optionsView,toolboxView,imageOpener);

        imageView.setVisible(true);
        optionsView.setVisible(true);
        toolboxView.setVisible(true);
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
