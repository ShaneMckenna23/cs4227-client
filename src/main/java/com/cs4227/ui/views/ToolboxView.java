package com.cs4227.ui.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ToolboxView extends JFrame {

    private static JComboBox dropdownFilterType;
    private static JLabel labelFilterType;

    public ToolboxView() throws IOException {
        super("Adjustments");

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

        dropdownFilterType = new JComboBox();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(dropdownFilterType,gbc);






        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }
}// end of class
