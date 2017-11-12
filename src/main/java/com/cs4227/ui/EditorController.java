package com.cs4227.ui;

import com.cs4227.ui.commands.*;
import com.cs4227.ui.components.Component;
import com.cs4227.ui.models.ExplorerSaveModel;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.models.ExplorerOpenModel;
import com.cs4227.ui.views.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorController {

    private ImageView imageView;
    private OptionsView optionsView;
    private AdjustmentsView adjustmentsView;
    private TransformView transformView;
    private ExplorerView explorerOpen;
    private ExplorerView explorerSave;

    private ImageModel imageModel;
    private ExplorerOpenModel explorerOpenModel;
    private ExplorerSaveModel explorerSaveModel;

    public EditorController(ImageView imageView, OptionsView optionsView, AdjustmentsView adjustmentsView, TransformView transformView) {

        //Views
        this.imageView = imageView;
        this.optionsView = optionsView;
        this.adjustmentsView = adjustmentsView;
        this.transformView = transformView;

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
        initializeAdjustmentsView(componentListener);
        initializeTransformView(componentListener);

        initializeExplorerOpen();
        initializeExplorerClose();
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

    private void initializeAdjustmentsView(ComponentListener componentListener) {
        this.adjustmentsView.addComponentListener(componentListener);

        this.adjustmentsView.addCommandToComponent("sldBrightness", new AdjustBrightnessCommand(adjustmentsView,imageView,imageModel));
        this.adjustmentsView.addCommandToComponent("APPLY", new ApplyFilterCommand(adjustmentsView, imageView, imageModel));
    }

    private void initializeTransformView(ComponentListener componentListener) {
        this.transformView.addComponentListener(componentListener);
    }

    private void initializeExplorerOpen() {
        this.explorerOpen.addApproveCommand(new OpenImageCommand(imageModel, imageView, explorerOpen, explorerOpenModel));
        this.explorerOpen.addCancelCommand(new CloseExplorerCommand(explorerOpenModel, explorerOpen));
    }

    private void initializeExplorerClose() {
        this.explorerSave.addApproveCommand(new SaveImageCommand(explorerSave, imageModel, explorerSaveModel));
        this.explorerSave.addCancelCommand(new CloseExplorerCommand(explorerOpenModel, explorerSave));
    }

    class ComponentListener implements ActionListener, ChangeListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Component component = (Component) e.getSource();
            component.onAction();
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Component component = (Component) e.getSource();
            component.onAction();
        }
    }
}
