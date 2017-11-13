package com.cs4227.framework.strategy;

import com.cs4227.framework.state.StateContext;
import org.apache.log4j.Logger;

import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.File;

public class SaveAsOther extends FileFilter implements SaveAsStrategy {

    private static final String FILE_TYPE_ERROR = "An incompatible file type was chosen. Cannot save file to directory: ";
    private static final String DESCRIPTION = "Other";

    Logger logger = Logger.getLogger(SaveAsOther.class);

    public boolean accept(File f)
    {
        if (f.isDirectory())
        {
            return false;
        }

        String s = f.getName();

        return !(s.endsWith(".png")||s.endsWith(".PNG")||s.endsWith(".jpg")||s.endsWith(".JPG")
                ||s.endsWith(".jpeg")||s.endsWith(".JPEG"));
    }

    public String getDescription()
    {
        return DESCRIPTION;
    }

    public void save(String destination, BufferedImage image, StateContext context){
        logger.error(FILE_TYPE_ERROR + destination);
        context.toggle();
    }
}
