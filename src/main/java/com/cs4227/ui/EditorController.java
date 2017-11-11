package com.cs4227.ui;

import com.cs4227.ui.commands.OpenCommand;
import com.cs4227.ui.commands.RedoCommand;
import com.cs4227.ui.commands.SaveCommand;
import com.cs4227.ui.commands.UndoCommand;
import com.cs4227.ui.components.Component;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.models.ImageOpenerModel;
import com.cs4227.ui.views.ImageOpener;
import com.cs4227.ui.views.ImageView;
import com.cs4227.ui.views.OptionsView;
import com.cs4227.ui.views.ToolboxView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorController {

    private ImageView imageView;
    private OptionsView optionsView;
    private ToolboxView toolboxView;
    private ImageOpener imageOpener;

    private ImageModel imageModel;
    private ImageOpenerModel imageOpenerModel;

    public EditorController(ImageView imageView, OptionsView optionsView, ToolboxView toolboxView, ImageOpener imageOpener) {
        this.imageView = imageView;
        this.optionsView = optionsView;
        this.toolboxView = toolboxView;
        this.imageOpener = imageOpener;

        ComponentListener componentListener = new ComponentListener();

        initializeImageView(componentListener);
        initializeToolBoxView(componentListener);
        initializeOptionsView(componentListener);
    }

    private void initializeImageView(ComponentListener componentListener) {
    }

    private void initializeToolBoxView(ComponentListener componentListener) {
        this.toolboxView.addComponentListeners(componentListener);
    }

    private void initializeOptionsView(ComponentListener componentListener) {
        this.optionsView.addComponentListeners(componentListener);

        imageOpenerModel = new ImageOpenerModel(this.imageOpener);
        this.optionsView.addCommandToComponent("OPEN", new OpenCommand(imageOpenerModel));

        this.optionsView.addCommandToComponent("SAVE", new SaveCommand());
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
