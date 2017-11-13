package com.cs4227.framework.strategy;

import com.cs4227.framework.interceptor.state.StateContext;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.nimbus.State;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveAsPNG extends FileFilter implements SaveAsStrategy {

    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file as PNG from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file as PNG from directory:  ";
    private static final String fileExtension = "png";
    private static final String description = "*.png,*.PNG";

    Logger logger = Logger.getLogger(SaveAsPNG.class);


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
        return description;
    }

    public void save(String destination, BufferedImage image, StateContext context) {
        try {
            ImageIO.write(image, fileExtension, new File(destination));
        } catch (IOException e) {
            context.toggle();
            logger.error(IO_ERROR + destination, e);
        } catch (Exception e) {
            context.toggle();
            logger.error(UNKNOWN_ERROR + destination, e);
        }
    }
}
