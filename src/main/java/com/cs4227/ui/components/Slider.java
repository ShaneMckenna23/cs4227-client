package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;

public class Slider extends JSlider implements Component{

    Command command;

    public Slider(int MIN, int MAX, int INIT, String name) {
        super(MIN, MAX, INIT);
        this.setName(name);
    }

    @Override
    public void onAction() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void addActionListener(ActionListener componentListener) {

    }

}
