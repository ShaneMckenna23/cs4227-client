package com.cs4227.ui.commands;

import com.cs4227.ui.components.FileChooser;
import com.cs4227.ui.models.ExplorerModel;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.ExplorerView;
import com.cs4227.ui.views.ImageView;

import javax.swing.*;

public class SaveStrategyCommand implements Command {

    private ImageModel imageModel;
    private ExplorerModel explorerModel;
    private ExplorerView explorerView;

    public SaveStrategyCommand(ExplorerView explorerView, ImageModel imageModel, ExplorerModel explorerModel) {
        this.imageModel = imageModel;
        this.explorerView = explorerView;
        this.explorerModel = explorerModel;
    }

    @Override
    public void execute() {
        String path = explorerView.getFileChooser().getSelectedFile().getParent();
        String name = explorerView.getFileChooser().getSelectedFile().getName();
        String ext = "";

        String extension = explorerView.getFileChooser().getFileFilter().getDescription();
        if (extension.equals("*.jpg,*.JPG,*.jpeg,*.JPEG")) {
            ext = ".jpg";
        }
        else if (extension.equals("*.png,*.PNG")) {
            ext = ".png";
        }

        String directory = path + "/" + name + ext;
        System.out.println(directory);
        //imageModel.saveImage(directory);

        imageModel.saveStrategy(path, name, ext);
        explorerModel.close();
        explorerView.setVisible(explorerModel.getIsExplorerOpen());

        JOptionPane.showMessageDialog (null, imageModel.getAlertMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void undo() {

    }
}