package com.cs4227.framework.visitor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RedImage implements Visitable{
    BufferedImage bufferedImage;
    double value;

    RedImage(BufferedImage bi){
        bufferedImage = bi;
    }
    public double getValue(){

        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int num = w * h;
        long sumr = 0;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                Color pixel = new Color(bufferedImage.getRGB(x, y));
                sumr += pixel.getRed();
            }
        }

        value = (int) ( sumr / num );
        return value;
    }

    @Override
    public double accept(Visitor visitor){
        return visitor.visit(this);
    }
}
