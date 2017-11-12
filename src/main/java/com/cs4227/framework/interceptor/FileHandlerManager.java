package com.cs4227.framework.interceptor;

import com.cs4227.framework.interceptor.state.LoggingDisableState;
import com.cs4227.framework.interceptor.state.LoggingEnableState;
import com.cs4227.framework.interceptor.state.StateContext;

import java.awt.image.BufferedImage;

public class FileHandlerManager {

    private FileHandlerDispatcherManager dispatcherManager;
    private LoggingEnableState loggingEnableState;
    private LoggingDisableState loggingDisableState;
    private StateContext loggingContext;
    private FileLoggingInterceptor loggingInterceptor;
    private FileWriterTarget fileWriterTarget;
    private FileReaderTarget fileReaderTarget;

    public FileHandlerManager() {
        initialize();
    }

    public BufferedImage openImage(String directory) {
        dispatcherManager.setTarget(fileReaderTarget);
        PreFileHandlerContext preRequestContext = createPreFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        PostFileHandlerContext postRequestContext = dispatcherManager.executeFileHandlerRequest(preRequestContext);
        return postRequestContext.getImage();
    }

    public String saveImage(String directory, BufferedImage image) {
        dispatcherManager.setTarget(fileWriterTarget);
        PreFileHandlerContext context = createPreFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        context.setImage(image);
        PostFileHandlerContext postRequestContext = dispatcherManager.executeFileHandlerRequest(context);
        return postRequestContext.getOutcomeContext().getState().stateMessage();
    }

    public void toggleLogging() {
        loggingContext.toggle();
    }

    private void initialize() {
        dispatcherManager = new FileHandlerDispatcherManager();
        fileReaderTarget = new FileReaderTarget();
        fileWriterTarget = new FileWriterTarget();
        loggingContext = new StateContext();
        loggingContext.setCreatorClass(FileHandlerManager.class.toString());
        loggingInterceptor = new FileLoggingInterceptor();
        loggingEnableState = new LoggingEnableState(loggingInterceptor, dispatcherManager);
        loggingDisableState = new LoggingDisableState(loggingInterceptor, dispatcherManager);
        loggingEnableState.setDisableState(loggingDisableState);
        loggingDisableState.setEnableState(loggingEnableState);
        //Logging is enabled by default
        loggingContext.setState(loggingEnableState);
        loggingEnableState.toggle(loggingContext);
    }

    private PreFileHandlerContext createPreFileHandlerContext(String directory, String method) {
        PreFileHandlerContext context = new PreFileHandlerContext();
        context.setDirectory(directory);
        context.setMethod(method);
        context.setStartTime(System.nanoTime());
        return context;
    }
}
