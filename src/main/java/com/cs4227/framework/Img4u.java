package com.cs4227.framework;

import com.cs4227.framework.abstractfactory.FactoryRotate;
import com.cs4227.framework.filters.Filter;
import com.cs4227.framework.filters.FilterFactory;
import com.cs4227.framework.filehandler.FileHandlerManager;

import java.awt.image.BufferedImage;

public class Img4u {

    private FileHandlerManager fileHandlerManager;
    private FilterFactory filterFactory;
    private FactoryRotate factoryRotate;
    private BrightnessEnhancer brightnessEnhancer;

    public Img4u(){
        this.fileHandlerManager = new FileHandlerManager();
        this.filterFactory = new FilterFactory();
        this.brightnessEnhancer = new BrightnessEnhancer();
    }

    public BufferedImage openImage(String directory){
        return fileHandlerManager.openImage(directory);
    }

    public String saveImage(String directory, BufferedImage image) {
        return fileHandlerManager.saveImage(directory,image);
    }

    public BufferedImage adjustImageBrightness(BufferedImage image, int brightnessValue) {
        System.out.print("Brightness value: " + brightnessValue);
        return brightnessEnhancer.convert(image, brightnessValue);
    }

    public BufferedImage applyFilter(BufferedImage image, String filterType) {
        Filter filter = filterFactory.createFilter(filterType);
        return filter.convert(image);
    }

    public BufferedImage applyRotate(BufferedImage image, String rotateDir, String rotateDeg) {
        FactoryRotate factoryRotateDir = factoryRotate.getRotateFactory(rotateDir).getRotate90();

        String result = "\nRotate:\nDirection = " + rotateDir + "\nDegrees = " + rotateDeg;
        System.out.println(result);
        return image;//no change to image yet
    }

    public BufferedImage applySizeChange(BufferedImage image, int w, int h) {
        //FilterAPI filter = filterFactory.createFilter(filterType);
        String result = "\nNew Size:\nWidth =  " + w + "\nHeight = " + h;
        System.out.println(result);
        return image;//no change to image yet
    }
}
