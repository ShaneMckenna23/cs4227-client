package com.cs4227.framework.abstractfactory;

class Rotate180 implements Interface180 {
    private String type;

    public Rotate180(String rType) {
        type = rType;
    }

    public String getRotate180() {
        return type;
    }

    public String getRotate180Details() {
        return "Rotated 180 Degrees";
    }
}