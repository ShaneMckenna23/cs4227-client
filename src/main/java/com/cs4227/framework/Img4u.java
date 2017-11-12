package com.cs4227.framework;

import com.cs4227.framework.interceptor.FileHandlerManager;

import java.awt.image.BufferedImage;

public class Img4u {

    private FileHandlerManager fileHandlerManager;

    public Img4u(){
        this.fileHandlerManager = new FileHandlerManager();
    }

    public BufferedImage openImage(String directory){
        return fileHandlerManager.openImage(directory);
    }

    public void saveImage(String directory, BufferedImage image) {
        fileHandlerManager.saveImage(directory,image);
    }

    public BufferedImage adjustImageBrightness(BufferedImage image, int brightnessValue) {
        System.out.print("Brightness value: " + brightnessValue);
        //todo
        return image;
    }
}
