package com.cs4227.framework.interceptor;

import java.awt.image.BufferedImage;

public class FileHandlerManager {

    private FileHandlerDispatcher dispatcher;
    private FileReaderTarget fileReaderTarget;
    private FileWriterTarget fileWriterTarget;
    private FileLoggingInterceptor fileLoggingInterceptor;
    private boolean loggingEnabled;


    public FileHandlerManager() {
        initialize();
    }

    protected void enableLogging() {
        if (loggingEnabled == false ) {
            dispatcher.registerInterceptor(fileLoggingInterceptor);
        }
        loggingEnabled = true;
    }

    protected void disableLogging() {
        if (loggingEnabled == true) {
            dispatcher.removeInterceptor(fileLoggingInterceptor);
        }
        loggingEnabled = false;
    }

    public BufferedImage openImage(String directory) {
        UnmarshalledFileHandlerContext context = createUnmarshalledFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        dispatcher.setTarget(fileReaderTarget);
        MarshalledFileHandlerContext marshalledContext = dispatcher.executeFileHandlerRequest(context);
        return marshalledContext.getImage();
    }

    public void saveImage(String directory, BufferedImage image) {
        UnmarshalledFileHandlerContext context = createUnmarshalledFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        context.setImage(image);
        dispatcher.setTarget(fileWriterTarget);
        dispatcher.executeFileHandlerRequest(context);
    }

    private void initialize() {
        dispatcher = new FileHandlerDispatcher();
        fileReaderTarget = new FileReaderTarget();
        fileWriterTarget = new FileWriterTarget();
        fileLoggingInterceptor = new FileLoggingInterceptor();
    }

    private UnmarshalledFileHandlerContext createUnmarshalledFileHandlerContext(String directory, String method) {
        UnmarshalledFileHandlerContext context = new UnmarshalledFileHandlerContext();
        context.setDirectory(directory);
        context.setMethod(method);
        context.setStartTime(System.nanoTime());
        return context;
    }

}
