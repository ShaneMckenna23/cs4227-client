package com.cs4227.ui.commands;

import com.cs4227.ui.Memento.MementoControl;

public class RedoCommand {

    public void execute() {
        System.out.print("Redo");


        int numberOfSaves = MementoControl.getImageCount();
        int currentIndex = MementoControl.getCurrentPathIndex();
        if ((numberOfSaves - 1) > currentIndex) {

            currentIndex++;
            MementoControl.setCurrentPathIndex(currentIndex);
            String frame = MementoControl.originator.restoreFromMemento(MementoControl.caretaker.getMemento(currentIndex));


        }
    }

    public void undo() {

    }
}
