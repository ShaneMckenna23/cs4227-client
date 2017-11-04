package com.cs4227.ui.components;

import com.cs4227.ui.commands.OpenCommand;

import javax.swing.*;

class ButtonOpen extends JButton {

    OpenCommand openCommand = new OpenCommand();

    public ButtonOpen(String name) {
        super(name);
    }

    public void onClick(){
        openCommand.execute();
    }
}
