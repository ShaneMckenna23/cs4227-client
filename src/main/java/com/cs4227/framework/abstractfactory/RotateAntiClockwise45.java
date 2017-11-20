package com.cs4227.framework.abstractfactory;

import java.awt.image.BufferedImage;

public class RotateAntiClockwise45 implements Rotate45 {
    @Override
    public BufferedImage rotate(BufferedImage image) {
        System.out.print("Rotate Anti Clockwise 45");
        return null;
    }
}
