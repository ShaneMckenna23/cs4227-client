class SaveAsJPG implements SaveAsStrategy {

    public void save(String destination, String imageName) {
        System.out.println(destination + imageName + ".JPG");
    }
}