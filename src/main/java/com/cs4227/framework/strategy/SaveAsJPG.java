package com.cs4227.framework.strategy;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class SaveAsJPG extends FileFilter implements SaveAsStrategy {
    public boolean accept(File file)
    {
        if (file.isDirectory())
        {
            return false;
        }

        String name = file.getName();

        return name.endsWith(".jpg")||name.endsWith(".JPG")||name.endsWith(".jpeg")||name.endsWith(".JPEG");
    }

    public String getDescription()
    {
        return "*.jpg,*.JPG,*.jpeg,*.JPEG";
    }

    public void save(String destination, String imageName){
        System.out.println("\n" + destination + "\n" + imageName);
    }
}
