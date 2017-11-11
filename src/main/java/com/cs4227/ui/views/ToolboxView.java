package com.cs4227.ui.views;

import com.cs4227.ui.commands.Command;
import com.cs4227.ui.components.Button;
import com.cs4227.ui.components.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ToolboxView extends JFrame implements View {

    private ArrayList<Component> components;

    private JComboBox dropdownFilterType;
    private JLabel labelFilterType;
    private JTextField txtImageWidth, txtImageHeight;
    private JSlider sldBrightness;

    public ToolboxView() throws IOException {
        super("Adjustments");

        this.setSize(220, 500);
        this.setLocation((1300), (250));

        JPanel buttonPanel = new JPanel();
        components = new ArrayList<Component>();

        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        labelFilterType = new JLabel("Filter Type:");
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(labelFilterType, gbc);
        buttonPanel.add(labelFilterType,gbc);

        String options [] = {"Select Filter", "Monochrome"};

        dropdownFilterType = new JComboBox(options);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(dropdownFilterType,gbc);

        txtImageHeight = new JTextField(5);
        gridbag.setConstraints(txtImageHeight, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel.add(txtImageHeight,gbc);

        txtImageWidth = new JTextField(5);
        gridbag.setConstraints(txtImageWidth, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        buttonPanel.add(txtImageWidth,gbc);

        sldBrightness = new JSlider();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        buttonPanel.add(sldBrightness,gbc);

        Button btnApply = new Button("Apply");
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gridbag.setConstraints(btnApply, gbc);
        buttonPanel.add(btnApply,gbc);
        components.add(btnApply);

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public void addComponentListeners(ActionListener componentListener) {
        for(Component c: components){
            c.addActionListener(componentListener);
        }
    }

    @Override
    public void addCommandToComponent(String name, Command command) {
        for(Component c: components){
            if(c.getName().equals(name)){
                c.setCommand(command);
            }
        }
    }

    public String getSelectedFilter() {
        return (String) dropdownFilterType.getSelectedItem();
    }
}
