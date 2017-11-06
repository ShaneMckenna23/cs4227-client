package com.cs4227.ui.commands;

public class SaveCommand implements Command {

    @Override
    public void execute() {
        System.out.print("Save File");
    }

    @Override
    public void undo() {

    }
}
