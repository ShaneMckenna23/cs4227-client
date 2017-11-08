package com.cs4227.ui.commands;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.ui.Start;

import java.awt.image.BufferedImage;

public class RedoCommand {

    public void execute() {
        System.out.print("Redo");

        int numberOfSaves = MementoControl.getImageCount();
        int currentIndex = MementoControl.getCurrentPathIndex();
        if ((numberOfSaves - 1) > currentIndex) {
            currentIndex++;
            MementoControl.setCurrentPathIndex(currentIndex);

            BufferedImage imagePath = MementoControl.originator.restoreFromMemento(MementoControl.caretaker.getMemento(currentIndex));
            try {
                Start.refreshImage(imagePath, imagePath.getWidth(), imagePath.getHeight());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void undo() {

    }
}
