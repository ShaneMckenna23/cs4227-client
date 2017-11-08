package com.cs4227.ui.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import com.cs4227.ui.ButtonHandler;
import com.cs4227.ui.components.ButtonOpen;
import com.cs4227.ui.components.ButtonRedo;
import com.cs4227.ui.components.ButtonSave;
import com.cs4227.ui.components.ButtonUndo;

public class OptionsView extends JFrame {

    public final String OPEN = "Open";
    public final String SAVE = "Save";
    public final String UNDO = "Undo";
    public final String REDO = "Redo";

    private ButtonOpen btnOpen;
    private ButtonSave btnSave;
    private ButtonUndo btnUndo;
    private ButtonRedo btnRedo;

    private JPanel optionsView;

    public OptionsView() throws Exception {
        super("Main");

        // Create Panel
        optionsView = new JPanel();

        ButtonHandler buttonHandler = new ButtonHandler();

        //Create buttons
        btnOpen = new ButtonOpen(OPEN);
        btnOpen.setMnemonic(KeyEvent.VK_O);
        btnOpen.addActionListener(buttonHandler);

        btnSave = new ButtonSave(SAVE);
        btnSave.setMnemonic(KeyEvent.VK_S);
        btnSave.addActionListener(buttonHandler);

        btnUndo = new ButtonUndo(UNDO);
        btnUndo.setMnemonic(KeyEvent.VK_U);
        btnUndo.addActionListener(buttonHandler);

        btnRedo = new ButtonRedo(REDO);
        btnRedo.setMnemonic(KeyEvent.VK_R);
        btnRedo.addActionListener(buttonHandler);

        //Button Panel
        JPanel buttonPanel = new JPanel();

        //----------------------------------------------
        GridBagLayout gridbag = new GridBagLayout();//Gridbage spaces out the layout
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(btnOpen);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnUndo);
        buttonPanel.add(btnRedo);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(btnOpen, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gridbag.setConstraints(btnSave, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gridbag.setConstraints(btnUndo, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gridbag.setConstraints(btnRedo, gbc);


        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);

    }
}