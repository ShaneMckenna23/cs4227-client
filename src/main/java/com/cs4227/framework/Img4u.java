package com.cs4227.framework;

import com.cs4227.framework.filters.Filter;
import com.cs4227.framework.filters.FilterFactory;
import com.cs4227.framework.interceptor.FileHandlerManager;

import java.awt.image.BufferedImage;

public class Img4u {

    private FileHandlerManager fileHandlerManager;
    private FilterFactory filterFactory;

    public Img4u(){
        this.fileHandlerManager = new FileHandlerManager();
        this.filterFactory = new FilterFactory();
    }

    public BufferedImage openImage(String directory){
        return fileHandlerManager.openImage(directory);
    }

    public String saveImage(String directory, BufferedImage image) {
        return fileHandlerManager.saveImage(directory,image);
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
}
