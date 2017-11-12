package com.cs4227.ui;

import com.cs4227.ui.commands.*;
import com.cs4227.ui.components.Component;
import com.cs4227.ui.models.ExplorerSaveModel;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.models.ExplorerOpenModel;
import com.cs4227.ui.views.ExplorerView;
import com.cs4227.ui.views.ImageView;
import com.cs4227.ui.views.OptionsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorController {

    private ImageView imageView;
    private OptionsView optionsView;

    private ExplorerView explorerOpen;
    private ExplorerView explorerSave;

    private ImageModel imageModel;
    private ExplorerOpenModel explorerOpenModel;
    private ExplorerSaveModel explorerSaveModel;

    public EditorController(ImageView imageView, OptionsView optionsView) {

        //Views
        this.imageView = imageView;
        this.optionsView = optionsView;

        this.explorerOpen = new ExplorerView("OPEN");
        this.explorerSave = new ExplorerView("SAVE");

        //Models
        imageModel = new ImageModel(this.imageView.getImage());
        explorerOpenModel = new ExplorerOpenModel();
        explorerSaveModel = new ExplorerSaveModel();

        //Wire Views -> Commands -> Models
        ComponentListener componentListener = new ComponentListener();
        initializeImageView(componentListener);
        initializeOptionsView(componentListener);

        initializeExplorerOpen();
        initializeExplorerClose();
    }

    private void initializeExplorerOpen() {
        this.explorerOpen.addApproveCommand(new OpenImageCommand(imageModel, imageView, explorerOpen, explorerOpenModel));
        this.explorerOpen.addCancelCommand(new CloseExplorerCommand(explorerOpenModel, explorerOpen));
    }

    private void initializeExplorerClose() {
        this.explorerSave.addApproveCommand(new SaveImageCommand(explorerSave, imageModel, explorerSaveModel));
        this.explorerSave.addCancelCommand(new CloseExplorerCommand(explorerOpenModel, explorerSave));
    }

    private void initializeImageView(ComponentListener componentListener) {
    }


    private void initializeOptionsView(ComponentListener componentListener) {
        this.optionsView.addComponentListener(componentListener);

        this.optionsView.addCommandToComponent("OPEN", new OpenExplorerCommand(explorerOpenModel, explorerOpen));
        this.optionsView.addCommandToComponent("SAVE", new OpenExplorerCommand(explorerSaveModel, explorerSave));
        this.optionsView.addCommandToComponent("UNDO", new UndoCommand());
        this.optionsView.addCommandToComponent("REDO", new RedoCommand());
    }

    class ComponentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Component component = (Component) e.getSource();
            component.onAction();
        }
    }
}
