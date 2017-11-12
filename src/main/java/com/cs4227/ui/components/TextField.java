package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;
import java.util.EventListener;

public class TextField extends JTextField implements Component{

    Command command;

    public TextField(int col, String name) {
        super(col);
        this.setName(name);
    }

    @Override
    public void onAction() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void addEventListener(EventListener componentListener) {

    }
}
