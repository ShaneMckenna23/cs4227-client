package com.cs4227.ui.components;

import com.cs4227.ui.commands.OpenCommand;

import javax.swing.*;

public class ButtonApply extends JButton implements Button{

    public ButtonApply(String name) {
        super(name);
    }

    @Override
    public void onClick() {
        System.out.print("Apply");
    }
}
