package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import java.awt.event.ActionListener;

public interface Component {
    void onAction();
    void setCommand(Command command);
    void addActionListener(ActionListener componentListener);
    String getName();
}

