package com.cs4227.ui.views;

import com.cs4227.ui.commands.Command;

import java.util.EventListener;

public interface ComponentView {
    void addComponentListener(EventListener componentListener);
    void addCommandToComponent(String name, Command command);
}
