package com.cs4227.ui.components;

import com.cs4227.ui.commands.ChangeFilterCommand;
import com.cs4227.ui.commands.OpenCommand;

import javax.swing.*;

public class ButtonApply extends JButton implements Button{

    ChangeFilterCommand changeFilterCommand = new ChangeFilterCommand();

    public ButtonApply(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        changeFilterCommand.execute();
    }
}
