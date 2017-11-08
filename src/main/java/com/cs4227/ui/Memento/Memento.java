package com.cs4227.ui.Memento;

public class Memento {

    private String imagePath;

    public Memento(String savedImagePath) {
        imagePath = savedImagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
