package com.cs4227.ui.views;

import com.cs4227.ui.commands.Command;
import com.cs4227.ui.components.FileChooser;

import javax.swing.*;
import java.awt.*;

public class ExplorerView extends JFrame {

    private FileChooser fileChooser;

    public ExplorerView(String type){
        super("Choose an Image");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fileChooser = new FileChooser("C://Users");
        fileChooser.setControlButtonsAreShown(true);
        if (type.equals("OPEN")){
            fileChooser.setDialogType(fileChooser.OPEN_DIALOG);
        }else {
            fileChooser.setDialogType(fileChooser.SAVE_DIALOG);
        }
        add(fileChooser, BorderLayout.CENTER);
        this.pack();
    }

    public void addApproveCommand(Command command) {
        fileChooser.setApproveCommandCommand(command);
    }

    public void addCancelCommand(Command command) {
        fileChooser.setCancelCommand(command);
    }
}
