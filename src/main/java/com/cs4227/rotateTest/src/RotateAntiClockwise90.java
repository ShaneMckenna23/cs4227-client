class RotateAntiClockwise90 implements Interface90 {
    private String type;

    public RotateAntiClockwise90(String rType) {
        type = rType;
    }

    public String getRotate90() {
        return type;
    }

    public String getRotate90Details() {
        return "Rotated 90 Degrees Anti Clockwise";
    }
}// End of class