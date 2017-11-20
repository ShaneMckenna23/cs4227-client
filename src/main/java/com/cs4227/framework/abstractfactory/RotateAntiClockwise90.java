package com.cs4227.framework.abstractfactory;

import java.awt.image.BufferedImage;

public class RotateAntiClockwise90 implements Rotate90 {
    @Override
    public BufferedImage rotate(BufferedImage image) {
        System.out.print("Rotate Anti Clockwise 90");
        return null;
    }
}
