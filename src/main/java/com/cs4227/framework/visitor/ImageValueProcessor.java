package com.cs4227.framework.visitor;

import java.awt.image.BufferedImage;

public class ImageValueProcessor {

    private AverageImage averageImage;
    private RedImage redImage;
    private GreenImage greenImage;
    private BlueImage blueImage;
    private ImageVisitor imageVisitor;

    public ImageValueProcessor(BufferedImage image){

        imageVisitor = new ImageVisitor();

        averageImage = new AverageImage(image);
        redImage = new RedImage(image);
        greenImage = new GreenImage(image);
        blueImage = new BlueImage(image);

        // Printing to the console for now. Feel free to remove this if you are putting it on the UI. -Will
        System.out.println("Blue: " + blueImage.accept(imageVisitor));
        System.out.println("Green: " + greenImage.accept(imageVisitor));
        System.out.println("Red: " + redImage.accept(imageVisitor));
        System.out.println("Average: " + averageImage.accept(imageVisitor));

    }

    public double getBlue(){
        System.out.println("Blue: " + blueImage.accept(imageVisitor));
        return blueImage.accept(imageVisitor);
    }

    public double getGreen(){
        System.out.println("Green: " + greenImage.accept(imageVisitor));
        return greenImage.accept(imageVisitor);
    }

    public double getRed(){
        System.out.println("Red: " + redImage.accept(imageVisitor));
        return redImage.accept(imageVisitor);
    }

    public double getAverageColour(){
        System.out.println("Average: " + averageImage.accept(imageVisitor));
        return averageImage.accept(imageVisitor);
    }

}
