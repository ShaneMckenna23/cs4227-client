package com.cs4227.ui.commands;

public class OpenImageCommand implements Command {

    @Override
    public void execute() {
        System.out.print("Open Image");
    }

    @Override
    public void undo() {

    }
}
