package com.cs4227.ui.commands;

import com.cs4227.ui.Memento.MementoControl;

public class UndoCommand {

    UndoCommand undoCommand = new UndoCommand();

    public void execute() {
        System.out.print("Undo");

        int currentImage = MementoControl.getCurrentPathIndex();
        System.out.println(currentImage);
        if (currentImage >= 1) {

            currentImage--;
            MementoControl.setCurrentPathIndex(currentImage);

            String imagePath = MementoControl.originator.restoreFromMemento( MementoControl.caretaker.getMemento(currentImage) );

            System.out.println("Previous Pressed.");
        }
    }

    public void undo() {

    }
}
