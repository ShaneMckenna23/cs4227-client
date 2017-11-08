package com.cs4227.ui;

import com.cs4227.framework.interceptor.FileHandlerManager;
import com.cs4227.ui.views.ImageView;
import com.cs4227.ui.views.OptionsView;
import com.cs4227.ui.views.ToolboxView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

public class Start {

    public static boolean isImageOpen,isToolsOpen;
    public static OptionsView optionsView;
    public static ImageView imageView;
    public static ToolboxView toolboxView;

    public static void main(String[] args) throws Exception {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        InputStream in = Start.class.getResourceAsStream("/imageDefault.jpg");
        BufferedImage selectedImage = ImageIO.read(in);

        imageView = new ImageView(selectedImage, 600, 600);//passing in default image
        imageView.setSize(620, 620);
        isImageOpen = true;
        imageView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isImageOpen = false;
            }});
        imageView.setLocation(dim.width/2-imageView.getSize().width/2, dim.height/2-imageView.getSize().height/2);
        imageView.setVisible(true);


        optionsView = new OptionsView();
        optionsView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        optionsView.setSize(600, 80);
        optionsView.setLocation(dim.width/2-imageView.getSize().width/2, dim.height/2-imageView.getSize().height/2 - 100);
        optionsView.setVisible(true);

        toolboxView = new ToolboxView();
        isToolsOpen = true;

        toolboxView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isToolsOpen = false;
            }});
        toolboxView.setSize(220, 500);
        toolboxView.setLocation((1300), (250));
        toolboxView.setVisible(true);

        FileHandlerManager fileHandlerManager = new FileHandlerManager();
    }

    public static void refreshImage (BufferedImage image, int w, int h) throws Exception {
        imageView.dispose();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        imageView = new ImageView(image, 600, 600);//passing in default image
        imageView.setSize(w, h);
        isImageOpen = true;
        imageView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isImageOpen = false;
            }});
        imageView.setLocation(dim.width/2-imageView.getSize().width/2, dim.height/2-imageView.getSize().height/2);
        imageView.setVisible(true);
    }
}
