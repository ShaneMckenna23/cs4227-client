package com.cs4227.ui.commands;

import java.io.IOException;

public interface Command {
    void execute();
    void undo();
}
