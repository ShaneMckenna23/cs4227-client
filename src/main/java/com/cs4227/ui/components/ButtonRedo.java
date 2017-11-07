package com.cs4227.ui.components;

import com.cs4227.ui.Memento.*;
import com.cs4227.ui.commands.RedoCommand;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonRedo extends JButton implements Button {

    RedoCommand redoCommand = new RedoCommand();

    public ButtonRedo(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        redoCommand.execute();
    }
}
