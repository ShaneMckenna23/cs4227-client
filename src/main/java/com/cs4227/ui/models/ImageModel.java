package com.cs4227.ui.models;

import com.cs4227.framework.Img4u;
import com.cs4227.framework.memento.MementoControl;
import com.cs4227.framework.visitor.ImageValueProcessor;
import com.cs4227.ui.components.FileChooser;
import com.cs4227.ui.views.ImageView;

import java.awt.image.BufferedImage;

public class ImageModel {

    private BufferedImage image;
    private String alertMessage;
    private Img4u img4u;

    public ImageModel(BufferedImage image){
        this.image = image;
        this.img4u = new Img4u();
    }

    public BufferedImage getImage(){
        return image;
    }

    public void readImage(FileChooser fileChooser) {
        String path = fileChooser.getSelectedFile().getPath();
        this.image = img4u.openImage(path);
    }

    public void saveImage(String path) {
        this.alertMessage = img4u.saveImage(path, image);
    }

    public void adjustImageBrightness(int brightnessValue) {
        this.image = img4u.adjustImageBrightness(image, brightnessValue);
    }

    public void ApplyFilter(String filterType) {
        this.image = img4u.applyFilter(image, filterType);
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void ApplyRotate(String rotateDir, String RotaateDeg) {
        this.image = img4u.applyRotate(image, rotateDir, RotaateDeg);
    }

    public void changeImage(ImageView imageView, BufferedImage image){

        MementoControl.originator.set( image );
        MementoControl.caretaker.addMemento( MementoControl.originator.storeInMemento() );
        MementoControl.setImagePathCount( MementoControl.getImageCount() + 1 );
        MementoControl.setCurrentPathIndex( MementoControl.getCurrentPathIndex() + 1 );

        ImageValueProcessor visitorExample = new ImageValueProcessor(image);
        visitorExample.printImageValue();
        visitorExample.logImageValue();

        imageView.setImage(image);

    }

    public void ApplySizeChange(int w, int h) {
        this.image = img4u.applySizeChange(image, w, h);
    }
}
