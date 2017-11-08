package com.cs4227.framework.interceptor;

import com.cs4227.ui.Start;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReaderTarget implements BaseFileHandlerTarget {


    @Override
    public MarshalledFileHandlerContext execute(UnmarshalledFileHandlerContext context) {

        MarshalledFileHandlerContext marshalledContext = createMarshalledContext(context);
        File selectedFile = new File(context.getDirectory());
        try {
            BufferedImage selectedImage = ImageIO.read(selectedFile);
            int width = selectedImage.getWidth();
            int height = selectedImage.getHeight();
            marshalledContext.setImage(selectedImage);
            marshalledContext.setOutcome(true);
        } catch (IOException e) {
            marshalledContext.setOutcome(false);
            e.printStackTrace();
        } catch (Exception e) {
            marshalledContext.setOutcome(false);
            e.printStackTrace();
        }
        marshalledContext.setOverallTime(System.nanoTime() - context.getStartTime());
        return marshalledContext;
    }

    private MarshalledFileHandlerContext createMarshalledContext(UnmarshalledFileHandlerContext context) {
        MarshalledFileHandlerContext marshalledContext = new MarshalledFileHandlerContext();
        //marshalledContext.setFileName(context.getFileName());
        marshalledContext.setDirectory(context.getDirectory());
        return marshalledContext;
    }
}
