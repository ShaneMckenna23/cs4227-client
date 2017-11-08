package com.cs4227.ui.views;

import com.cs4227.ui.ButtonHandler;
import com.cs4227.ui.components.ButtonApply;
import com.cs4227.ui.components.ButtonOpen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ToolboxView extends JFrame {

    private static JComboBox dropdownFilterType;
    private static JLabel labelFilterType;
    private static JTextField txtImageWidth, txtImageHeight;
    private static JSlider sldBrightness;

    public ToolboxView() throws IOException {
        super("Adjustments");

        ButtonHandler buttonHandler = new ButtonHandler();
        JPanel buttonPanel = new JPanel();

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

        ButtonApply btnApply = new ButtonApply("Apply");
        btnApply.addActionListener(buttonHandler);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gridbag.setConstraints(btnApply, gbc);
        buttonPanel.add(btnApply,gbc);

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    public static String getSelectedFilter() {
        return (String) dropdownFilterType.getSelectedItem();
    }
}// end of class
