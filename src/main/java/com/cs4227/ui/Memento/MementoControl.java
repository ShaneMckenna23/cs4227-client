package com.cs4227.ui.Memento;

public class MementoControl {

    private static int imageCount;
    private static int currentPathNumber;

    // Not sure if I need this at all yet.
    private String imagePath;

    public static final Caretaker caretaker = new Caretaker();
    public static final Originator originator = new Originator();

    //Holding the Total and the Count of the Mementos

    public static void setCurrentPathIndex(int NextCountValue) {
        currentPathNumber = NextCountValue;
    }

    public static void setImagePathCount(int NextCountValue) {
        imageCount = NextCountValue;
    }

    public static int getCurrentPathIndex() {
        return currentPathNumber;
    }

    public static int getImageCount(){
        return imageCount;
    }

}
