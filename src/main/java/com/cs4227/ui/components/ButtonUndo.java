package com.cs4227.ui.components;

import com.cs4227.ui.commands.UndoCommand;

import javax.swing.*;

public class ButtonUndo extends JButton implements Button {

    UndoCommand undoCommand = new UndoCommand();
    public ButtonUndo(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        undoCommand.execute();
    }
}