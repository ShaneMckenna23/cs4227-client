package com.cs4227.ui.models;

import com.cs4227.framework.Img4u;
import com.cs4227.ui.components.FileChooser;

import java.awt.image.BufferedImage;

public class ImageModel {
    private BufferedImage image;
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
        img4u.saveImage(path, image);
    }

    public void adjustImageBrightness(int brightnessValue) {
        this.image = img4u.adjustImageBrightness(image, brightnessValue);
    }

    public void ApplyFilter(String filterType) {
        this.image = img4u.applyFilter(image, filterType);
    }
}
