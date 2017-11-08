class RotateClockwise90 implements Interface90 {
    private String type;

    public RotateClockwise90(String rType) {
        type = rType;
    }

    public String getRotate90() {
        return type;
    }

    public String getRotate90Details() {
        return "Rotated 90 Degrees Clockwise";
    }
}// End of class