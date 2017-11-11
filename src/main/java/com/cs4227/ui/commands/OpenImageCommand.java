package com.cs4227.ui.commands;

import com.cs4227.ui.components.FileChooser;
import com.cs4227.ui.models.ExplorerModel;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.ExplorerView;
import com.cs4227.ui.views.ImageView;

import java.io.File;

public class OpenImageCommand implements Command {

    private ImageModel imageModel;
    private ImageView imageView;
    private ExplorerView explorerView;
    private ExplorerModel explorerModel;

    public OpenImageCommand(ImageModel imageModel, ImageView imageView, ExplorerView explorerView, ExplorerModel explorerModel){
        this.imageModel = imageModel;
        this.imageView = imageView;
        this.explorerView = explorerView;
        this.explorerModel = explorerModel;
    }

    @Override
    public void execute() {
        imageModel.readImage(explorerView.getFileChooser());
        imageView.setImage(imageModel.getImage());
        explorerModel.close();
        explorerView.setVisible(explorerModel.getIsExplorerOpen());
    }

    @Override
    public void undo() {

    }
}
