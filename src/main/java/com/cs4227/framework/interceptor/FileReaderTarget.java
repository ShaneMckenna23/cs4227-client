package com.cs4227.framework.interceptor;

import com.cs4227.framework.interceptor.state.StateContext;
import com.cs4227.framework.interceptor.state.TargetFailureState;
import com.cs4227.framework.interceptor.state.TargetSuccessState;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReaderTarget implements BaseFileHandlerTarget {

    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to read the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to read the file from directory:  ";

    private StateContext outcomeContext;
    private Logger logger = Logger.getLogger(FileReaderTarget.class);

    public FileReaderTarget() {
        outcomeContext = new StateContext();
    }

    @Override
    public PostFileHandlerContext execute(PreFileHandlerContext context) {
        PostFileHandlerContext postRequestContext = createPostRequestContext(context);
        File selectedFile = new File(context.getDirectory());
        try {
            BufferedImage selectedImage = ImageIO.read(selectedFile);
            int width = selectedImage.getWidth();
            int height = selectedImage.getHeight();
            postRequestContext.setImage(selectedImage);
            setSuccessState();
        } catch (IOException e) {
            setFailureState();
            postRequestContext.setImage(null);
            logger.error(IO_ERROR + context.getDirectory(), e);
        } catch (Exception e) {
            setFailureState();
            postRequestContext.setImage(null);
            logger.error(UNKNOWN_ERROR + context.getDirectory(), e);
        }
        postRequestContext.setOutcomeContext(outcomeContext);
        postRequestContext.setOverallTime(System.nanoTime() - context.getStartTime());
        return postRequestContext;
    }

    private PostFileHandlerContext createPostRequestContext(PreFileHandlerContext context) {
        PostFileHandlerContext postRequestContext = new PostFileHandlerContext();
        postRequestContext.setMethod(context.getMethod());
        return postRequestContext;
    }

    private void setFailureState() {
        TargetFailureState state = new TargetFailureState();
        state.toggle(outcomeContext);
    }

    private void setSuccessState() {
        TargetSuccessState state = new TargetSuccessState();
        state.toggle(outcomeContext);
    }
}
