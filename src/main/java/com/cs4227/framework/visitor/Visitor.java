package com.cs4227.framework.visitor;

import java.awt.image.BufferedImage;

public interface Visitor {
    public double visit(RedImage redImage);
    public double visit(GreenImage greenImage);
    public double visit(BlueImage blueImage);
    public double visit(AverageImage averageImage);
}
