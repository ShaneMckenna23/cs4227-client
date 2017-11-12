package com.cs4227.framework.interceptor;

import com.cs4227.framework.interceptor.state.StateContext;
import com.cs4227.framework.interceptor.state.TargetFailureState;
import com.cs4227.framework.interceptor.state.TargetSuccessState;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.io.File;

public class FileWriterTarget implements BaseFileHandlerTarget {

    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file from directory:  ";

    private StateContext outcomeContext;
    private Logger logger = Logger.getLogger(FileWriterTarget.class);

    public FileWriterTarget() {
        outcomeContext = new StateContext();
    }

    @Override
    public PostFileHandlerContext execute(PreFileHandlerContext context) {
        try{
            File outputFile = new File(context.getDirectory());
            String path = context.getDirectory().toString();
            String[] pathParts = path.split("\\\\");
            String filename = pathParts[pathParts.length-1];
            String fileExtension = filename.split("\\.")[1]+"";
            ImageIO.write(context.getImage(), fileExtension, outputFile);
        }catch (Exception e){
            System.out.print("Error!");
            e.printStackTrace();
        }
        setFailureState();
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
