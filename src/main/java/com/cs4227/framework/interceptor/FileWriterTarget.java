package com.cs4227.framework.interceptor;

import com.cs4227.framework.interceptor.state.StateContext;
import com.cs4227.framework.interceptor.state.TargetFailureState;
import com.cs4227.framework.interceptor.state.TargetSuccessState;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileWriterTarget implements BaseFileHandlerTarget {
    private FileHandlerDispatcherManager dispatcherManager;

    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file from directory:  ";

    private StateContext outcomeContext;
    private Logger logger = Logger.getLogger(FileWriterTarget.class);

    public FileWriterTarget() {
        outcomeContext = new StateContext();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String saveStrategy(String path, String imageName, String extension, BufferedImage image) {
        String directory = path + "/" + imageName + extension;

        System.out.println("\n" + directory);

        dispatcherManager = new FileHandlerDispatcherManager(new FileWriterTarget());
        PreFileHandlerContext context = createPreFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        context.setImage(image);
        PostFileHandlerContext postRequestContext = dispatcherManager.executeFileHandlerRequest(context);
        return postRequestContext.getOutcomeContext().getState().stateMessage();
    }

    private PreFileHandlerContext createPreFileHandlerContext(String directory, String method) {
        PreFileHandlerContext context = new PreFileHandlerContext();
        context.setDirectory(directory);
        context.setMethod(method);
        context.setStartTime(System.nanoTime());
        return context;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public PostFileHandlerContext execute(PreFileHandlerContext context) {
        try{
            File outputFile = new File(context.getDirectory());
            String path = context.getDirectory().toString();
            String[] pathParts = path.split("\\\\");
            String filename = pathParts[pathParts.length-1];
            String fileExtension = filename.split("\\.")[1]+"";
            ImageIO.write(context.getImage(), fileExtension, outputFile);
            setSuccessState();
        } catch (IOException e) {
            setFailureState();
            logger.error(IO_ERROR + context.getDirectory(), e);
        } catch (Exception e) {
            setFailureState();
            logger.error(UNKNOWN_ERROR + context.getDirectory(), e);
        }
        PostFileHandlerContext postRequestContext = createPostRequestContext(context);
        postRequestContext.setOutcomeContext(outcomeContext);
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
