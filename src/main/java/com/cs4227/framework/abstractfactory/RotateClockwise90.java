package com.cs4227.framework.abstractfactory;

import java.awt.image.BufferedImage;

public class RotateClockwise90 implements Rotate90 {
    @Override
    public BufferedImage rotate(BufferedImage image) {
        System.out.print("Rotate Clockwise 90");
        return null;
    }
}
