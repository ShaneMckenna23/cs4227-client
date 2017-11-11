package com.cs4227.ui.models;

import javax.swing.*;

public class ImageOpenerModel {
    JFrame frame;

    public ImageOpenerModel(JFrame frame){
        this.frame = frame;
    }

    public void openImageOpener() {
        frame.setVisible(true);
    }

    public void closeImageOpener() {
        frame.setVisible(true);
    }
}
