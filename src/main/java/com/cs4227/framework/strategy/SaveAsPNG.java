package com.cs4227.framework.strategy;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class SaveAsPNG extends FileFilter implements SaveAsStrategy {
    public boolean accept(File file)
    {
        if (file.isDirectory())
        {
            return false;
        }

        String name = file.getName();

        return name.endsWith(".png")||name.endsWith(".PNG");
    }

    public String getDescription()
    {
        return "*.png,*.PNG";
    }

    public void save(String destination, String imageName){
        System.out.println("\n" + destination + "\n" + imageName);
    }
}
