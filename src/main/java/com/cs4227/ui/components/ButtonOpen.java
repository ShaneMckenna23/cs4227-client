package com.cs4227.ui.components;

import com.cs4227.ui.commands.OpenCommand;

import javax.swing.*;

public class ButtonOpen extends JButton implements Button{

    OpenCommand openCommand = new OpenCommand();

    public ButtonOpen(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        openCommand.execute();
    }
}
