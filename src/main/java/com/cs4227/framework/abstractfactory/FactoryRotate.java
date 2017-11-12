package com.cs4227.framework.abstractfactory;

public abstract class FactoryRotate {
    public static final String CLOCKWISE = "Clockwise";
    public static final String ANTICLOCKWISE = "Anticlockwise";

    public abstract Interface90 getRotate90();
    public abstract Interface180 getRotate180();

    public static FactoryRotate getSizeFactory(String type) {
        if (type.equals(FactoryRotate.CLOCKWISE))
            return new FactoryRotateClockwise();
        if (type.equals(FactoryRotate.ANTICLOCKWISE))
            return new FactoryRotateAntiClockwise();

        return new FactoryRotateAntiClockwise();
    }

} // End of class