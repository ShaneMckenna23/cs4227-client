package com.cs4227.framework;

import com.cs4227.framework.filters.Filter;
import com.cs4227.framework.filters.FilterFactory;
import com.cs4227.framework.interceptor.FileHandlerManager;
import com.cs4227.framework.interceptor.FileWriterTarget;

import java.awt.image.BufferedImage;

public class Img4u {

    private FileHandlerManager fileHandlerManager;
    private FileWriterTarget fileWriterTarget;
    private FilterFactory filterFactory;

    public Img4u(){
        this.fileHandlerManager = new FileHandlerManager();
        this.filterFactory = new FilterFactory();
    }

    public BufferedImage openImage(String directory){
        return fileHandlerManager.openImage(directory);
    }

    public void saveImage(String directory, BufferedImage image) {
        fileHandlerManager.saveImage(directory,image);
    }

    public void saveStrategy(String directory, String imageName, String extension, BufferedImage image) {
        fileWriterTarget.saveStrategy(directory, imageName, extension, image);
    }

    public BufferedImage adjustImageBrightness(BufferedImage image, int brightnessValue) {
        System.out.print("Brightness value: " + brightnessValue);
        //todo
        return image;
    }

    public BufferedImage applyFilter(BufferedImage image, String filterType) {
        Filter filter = filterFactory.createFilter(filterType);
        return filter.convert(image);
    }

    public BufferedImage applyRotate(BufferedImage image, String rotateDir, String rotateDeg) {
        //Filter filter = filterFactory.createFilter(filterType);
        String result = "\nRotate:\nDirection = " + rotateDir + "\nDegrees = " + rotateDeg;
        System.out.println(result);
        return image;//no change to image yet
    }

    public BufferedImage applySizeChange(BufferedImage image, int w, int h) {
        //Filter filter = filterFactory.createFilter(filterType);
        String result = "\nNew Size:\nWidth =  " + w + "\nHeight = " + h;
        System.out.println(result);
        return image;//no change to image yet
    }
}
