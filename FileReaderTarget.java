package com.cs4227.Interceptor;

import com.cs4227.ui.Start;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReaderTarget implements BaseTarget {


    @Override
    public MarshalledBaseContext execute(UnmarshalledBaseContext context) {

        MarshalledFileLoggingContext marshalledContext = createMarshalledContext(context);
        File selectedFile = new File(context.getDirectory());
        try {
            BufferedImage selectedImage = ImageIO.read(selectedFile);
            int width = selectedImage.getWidth();
            int height = selectedImage.getHeight();
            Start.refreshImage(selectedImage, width, height);
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

    private MarshalledFileLoggingContext createMarshalledContext(UnmarshalledBaseContext context) {
        MarshalledFileLoggingContext marshalledContext = new MarshalledFileLoggingContext();
        marshalledContext.setFileName(context.getFileName());
        marshalledContext.setDirectory(context.getDirectory());
        return marshalledContext;
    }
}
