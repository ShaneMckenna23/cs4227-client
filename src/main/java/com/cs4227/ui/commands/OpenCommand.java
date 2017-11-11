package com.cs4227.ui.commands;

import com.cs4227.ui.models.ImageOpenerModel;
import com.cs4227.ui.views.ImageOpener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OpenCommand implements Command {

    private ImageOpenerModel imageOpenerModel;

    public OpenCommand(ImageOpenerModel imageOpenerModel){
        this.imageOpenerModel = imageOpenerModel;
    }

    @Override
    public void execute() {
        imageOpenerModel.openImageOpener();
    }

    @Override
    public void undo() {

    }
}
