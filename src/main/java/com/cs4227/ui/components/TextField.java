package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;

public class TextField extends JTextField implements Component{

    Command command;

    public TextField(int col) {
        super(col);
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
