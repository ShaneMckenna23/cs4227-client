package com.cs4227.ui.commands;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.ui.Start;

import java.awt.image.BufferedImage;

public class UndoCommand {

    public void execute() {
        System.out.print("Undo");

        int currentImage = MementoControl.getCurrentPathIndex();
        System.out.println(currentImage);
        if (currentImage >= 1) {

            currentImage--;
            MementoControl.setCurrentPathIndex(currentImage);

            BufferedImage imagePath = MementoControl.originator.restoreFromMemento( MementoControl.caretaker.getMemento(currentImage) );
            try {
                Start.refreshImage(imagePath, imagePath.getWidth(), imagePath.getHeight());
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Previous Pressed.");
        }
    }

    public void undo() {

    }
}
