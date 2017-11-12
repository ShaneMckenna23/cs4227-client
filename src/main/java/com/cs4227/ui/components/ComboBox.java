package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;

public class ComboBox extends JComboBox implements Component{

    Command command;

    public ComboBox(String types[]) {
        super(types);
        //this.setName(name);
    }

    @Override
    public void onAction() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
