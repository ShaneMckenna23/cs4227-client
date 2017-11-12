package com.cs4227.framework.strategy;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class SaveAsPNG extends FileFilter implements SaveAsStrategy {
    public boolean accept(File f)
    {
        if (f.isDirectory())
        {
            return false;
        }

        String s = f.getName();

        return s.endsWith(".png")||s.endsWith(".PNG");
    }

    public String getDescription()
    {
        return "*.png,*.PNG";
    }

    public void save(String destination, String imageName){
        System.out.println("\n" + destination + "\n" + imageName);
    }
}
