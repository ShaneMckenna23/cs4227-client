package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

public interface Button {
    public void onClick();
    public void setCommand(Command command);
}
