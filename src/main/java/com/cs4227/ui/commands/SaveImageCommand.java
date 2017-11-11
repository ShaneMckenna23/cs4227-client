package com.cs4227.ui.commands;

import com.cs4227.ui.components.FileChooser;
import com.cs4227.ui.models.ExplorerModel;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.ExplorerView;
import com.cs4227.ui.views.ImageView;

public class SaveImageCommand implements Command {

    private ImageModel imageModel;
    private ExplorerView explorerView;

    public SaveImageCommand(ExplorerView explorerView, ImageModel imageModel){
        this.imageModel = imageModel;
        this.explorerView = explorerView;
    }

    @Override
    public void execute() {
        FileChooser fileChooser = explorerView.getFileChooser();
        String path = fileChooser.getSelectedFile().getAbsolutePath();
        String fileName = fileChooser.getSelectedFile().getName();
        imageModel.saveImage(fileName, path);
    }

    @Override
    public void undo() {

    }
}
