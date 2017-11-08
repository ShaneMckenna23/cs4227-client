package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;

public class ButtonSave extends JButton implements Button{

    Command saveCommand;

    public ButtonSave(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        saveCommand.execute();
    }
}
