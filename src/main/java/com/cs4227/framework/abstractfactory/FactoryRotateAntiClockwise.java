package com.cs4227.framework.abstractfactory;

class FactoryRotateAntiClockwise extends FactoryRotate {

    public Interface90 getRotate90() {
        return new RotateAntiClockwise90("Anti-CW-90");
    }
    public Interface180 getRotate180() {
        return new Rotate180("Anti-CW-180");
    }
} // End of class