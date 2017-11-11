package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;

public class Button extends JButton implements Component{

    Command command;

    public Button(String name) {
        super(name);
        this.setName(name);
    }

    @Override
    public void onAction() {
        command.execute();
    }

    @Override
    public void setCommand(Command command) {
        this.command = command;
    }
}
