package com.cs4227.framework.interceptor;

import com.cs4227.framework.interceptor.state.LoggingDisabledState;
import com.cs4227.framework.interceptor.state.LoggingEnabledState;
import com.cs4227.framework.interceptor.state.StateContext;

import java.awt.image.BufferedImage;

public class FileHandlerManager {

    private FileHandlerDispatcherManager dispatcherManager;
    private LoggingEnabledState loggingEnabledState;
    private LoggingDisabledState loggingDisabledState;
    private StateContext loggingContext;
    private FileLoggingInterceptor loggingInterceptor;

    public FileHandlerManager() {
        initialize();
    }

    public BufferedImage openImage(String directory) {
        dispatcherManager = new FileHandlerDispatcherManager(new FileReaderTarget());
        PreFileHandlerContext preRequestContext = createPreFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        PostFileHandlerContext postRequestContext = dispatcherManager.executeFileHandlerRequest(preRequestContext);
        return postRequestContext.getImage();
    }

    public void saveImage(String directory, BufferedImage image) {
        dispatcherManager = new FileHandlerDispatcherManager(new FileWriterTarget());
        PreFileHandlerContext context = createPreFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        context.setImage(image);
        dispatcherManager.executeFileHandlerRequest(context);
    }

    public void enableLogging() {
        if(loggingContext.getState() == loggingDisabledState) {
            loggingDisabledState.toggle(loggingContext);
            dispatcherManager.addInterceptor(loggingInterceptor);
        }
    }

    public void disableLogging() {
        if(loggingContext.getState() == loggingEnabledState) {
            loggingDisabledState.toggle(loggingContext);
            dispatcherManager.removeInterceptor(loggingInterceptor);
        }
    }

    public void setDispatcherManager(FileHandlerDispatcherManager manager) {
        this.dispatcherManager = manager;
    }

    private void initialize() {
        FileHandlerDispatcherManager manager = new FileHandlerDispatcherManager(new FileReaderTarget());
        this.setDispatcherManager(manager);
        loggingContext = new StateContext();
        loggingContext.setCreatorClass(FileHandlerManager.class.toString());
        loggingEnabledState = new LoggingEnabledState();
        loggingDisabledState = new LoggingDisabledState();
        //Logging is enabled by default
        loggingEnabledState.toggle(loggingContext);
        loggingInterceptor = new FileLoggingInterceptor();
        dispatcherManager.addInterceptor(loggingInterceptor);
    }

    private PreFileHandlerContext createPreFileHandlerContext(String directory, String method) {
        PreFileHandlerContext context = new PreFileHandlerContext();
        context.setDirectory(directory);
        context.setMethod(method);
        context.setStartTime(System.nanoTime());
        return context;
    }
}
