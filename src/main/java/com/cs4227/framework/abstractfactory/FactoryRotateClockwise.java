package com.cs4227.framework.abstractfactory;

class FactoryRotateClockwise extends FactoryRotate {

    public Interface90 getRotate90() {
        return new RotateClockwise90("CW-90");
    }
    public Interface180 getRotate180() {
        return new Rotate180("CW-180");
    }
} // End of class of class