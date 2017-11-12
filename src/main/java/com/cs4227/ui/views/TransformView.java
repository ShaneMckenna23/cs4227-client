package com.cs4227.ui.views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.cs4227.ui.commands.*;
import com.cs4227.ui.components.Button;
import com.cs4227.ui.components.ComboBox;
import com.cs4227.ui.components.Component;
import com.cs4227.ui.components.Slider;

public class TransformView extends JFrame implements View{

    private ArrayList<Component> components;
    private ComboBox cmbRotateDir, cmbRotateDeg;
    private Button btnApplyR, btnApplyS;
    private TextField txtImageWidth, txtImageHeight;

    private JLabel lblRotate, lblRotateDir, lblRotateDeg, lblSize, lblSizeWidth, lblSizeHeight;

    public TransformView() {
        super("Transform");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(260, 400);
        this.setLocation(390, 450);

        //Button Panel
        JPanel buttonPanel = new JPanel();

        components = new ArrayList<Component>();

        lblRotate = new JLabel("Rotation:");
        lblRotateDir = new JLabel("Direction:");
        lblRotateDeg = new JLabel("Degrees:");

        String tempDir[] = {"Clockwise", "Anti-Clockwise"};
        cmbRotateDir = new ComboBox(tempDir);

        String tempDeg[] = {"90 Degrees", "180 Degrees"};
        cmbRotateDeg = new ComboBox(tempDeg);

        btnApplyR = new Button("ROTATE");
        btnApplyR.setMnemonic(KeyEvent.VK_R);

        lblSize = new JLabel("Image Size:");
        lblSizeWidth = new JLabel("Width:");
        lblSizeHeight = new JLabel("Height:");

        txtImageWidth = new TextField(5);
        txtImageHeight = new TextField(5);

        btnApplyS = new Button("CHANGE SIZE");
        btnApplyS.setMnemonic(KeyEvent.VK_S);
        //Layout
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        /*gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblRotate, gbc);
        buttonPanel.add(lblRotate,gbc);*/

        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblRotateDir, gbc);
        buttonPanel.add(lblRotateDir);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(cmbRotateDir, gbc);
        buttonPanel.add(cmbRotateDir,gbc);
        components.add(cmbRotateDir);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblRotateDeg, gbc);
        buttonPanel.add(lblRotateDeg);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(cmbRotateDeg, gbc);
        buttonPanel.add(cmbRotateDeg,gbc);
        components.add(cmbRotateDeg);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gridbag.setConstraints(btnApplyR, gbc);
        buttonPanel.add(btnApplyR);
        components.add(btnApplyR);

        /*gbc.gridx = 0;
        gbc.gridy = 6;
        gridbag.setConstraints(lblSize, gbc);
        buttonPanel.add(lblSize);*/

        gbc.gridx = 0;
        gbc.gridy = 7;
        gridbag.setConstraints(lblSizeWidth, gbc);
        buttonPanel.add(lblSizeWidth);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gridbag.setConstraints(txtImageWidth, gbc);
        buttonPanel.add(txtImageWidth);
        //components.add(txtImageWidth); i guess textfields shudnt be components

        gbc.gridx = 0;
        gbc.gridy = 9;
        gridbag.setConstraints(lblSizeHeight, gbc);
        buttonPanel.add(lblSizeHeight);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gridbag.setConstraints(txtImageHeight, gbc);
        buttonPanel.add(txtImageHeight);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gridbag.setConstraints(btnApplyS, gbc);
        buttonPanel.add(btnApplyS);
        components.add(btnApplyS);

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public void addComponentListener(ActionListener componentListener) {
        for(com.cs4227.ui.components.Component c: components){
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
}