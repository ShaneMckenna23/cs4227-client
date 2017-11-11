package com.cs4227.ui.commands;

public class SaveImageCommand implements Command{

    @Override
    public void execute() {
        System.out.print("Save Image!");
    }

    @Override
    public void undo() {

    }
}
