package com.cs4227.ui.components;

import com.cs4227.ui.commands.SaveCommand;

import javax.swing.*;

public class ButtonSave extends JButton implements Button{

    SaveCommand saveCommand = new SaveCommand();

    public ButtonSave(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        saveCommand.execute();
    }
}
