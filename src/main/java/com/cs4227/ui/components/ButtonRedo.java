package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;
import com.cs4227.ui.commands.RedoCommand;

import javax.swing.*;

public class ButtonRedo extends JButton implements Button {

    Command command;

    public ButtonRedo(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        command.execute();
    }

    @Override
    public void setCommand(Command command) {
        this.command = command;
    }
}
