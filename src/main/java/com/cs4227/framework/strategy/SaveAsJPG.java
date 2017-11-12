package com.cs4227.framework.strategy;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class SaveAsJPG extends FileFilter implements SaveAsStrategy {
    public boolean accept(File f)
    {
        if (f.isDirectory())
        {
            return false;
        }

        String s = f.getName();

        return s.endsWith(".jpg")||s.endsWith(".JPG")||s.endsWith(".jpeg")||s.endsWith(".JPEG");
    }

    public String getDescription()
    {
        return "*.jpg,*.JPG,*.jpeg,*.JPEG";
    }

    public void save(String destination, String imageName){
        System.out.println("\n" + destination + "\n" + imageName);
    }
}
