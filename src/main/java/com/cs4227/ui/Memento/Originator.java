package com.cs4227.ui.Memento;

public class Originator {

    private String imagePath;

    public void set(String savedImagePath){
        System.out.println("From Originator: Current Version of Image\n");
        imagePath = savedImagePath;
    }

    public Memento storeInMemento(){
        System.out.println("From Originator: Saving to Memento");
        return new Memento(imagePath);
    }

    // This can be removed but I'll keep it for now in case of a change.
    public String restoreFromMemento(Memento memento){
        imagePath = memento.getImagePath();
        System.out.println("From Originator: Restoring Path from Memento");
        return imagePath;
    }

}
