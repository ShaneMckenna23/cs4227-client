package com.cs4227.ui.views;

import com.cs4227.ui.commands.Command;

import java.awt.event.ActionListener;

public interface View {
    void addComponentListener(ActionListener componentListener);
    void addCommandToComponent(String name, Command command);
}
