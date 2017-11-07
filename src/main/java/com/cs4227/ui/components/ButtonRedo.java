package com.cs4227.ui.components;

import com.cs4227.ui.commands.RedoCommand;

import javax.swing.*;

public class ButtonRedo extends JButton implements Button {

    RedoCommand redoCommand = new RedoCommand();

    public ButtonRedo(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        redoCommand.execute();
    }
}
