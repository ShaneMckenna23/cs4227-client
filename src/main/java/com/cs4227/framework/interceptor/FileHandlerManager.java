package com.cs4227.framework.interceptor;

import java.awt.image.BufferedImage;

public class FileHandlerManager {

    private FileHandlerDispatcher dispatcher;
    private FileReaderTarget fileReaderTarget;
    private FileWriterTarget fileWriterTarget;
    private FileLoggingInterceptor fileLoggingInterceptor;


    public FileHandlerManager() {
        initialize();
    }

    protected void enableLogging() {
        dispatcher.registerInterceptor(fileLoggingInterceptor);
    }

    public void openImage(String directory) {
        UnmarshalledFileHandlerContext context = createUnmarshalledFileContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        dispatcher.setTarget(fileReaderTarget);
        dispatcher.dispatchFileHandlerInterceptorPreMarshal(context);
    }

    public void saveImage(String directory, BufferedImage image) {
        UnmarshalledFileHandlerContext context = createUnmarshalledFileContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        context.setImage(image);
        dispatcher.setTarget(fileWriterTarget);
        dispatcher.dispatchFileHandlerInterceptorPreMarshal(context);
    }

    private void initialize() {
        dispatcher = new FileHandlerDispatcher();
        fileReaderTarget = new FileReaderTarget();
        fileWriterTarget = new FileWriterTarget();
        fileLoggingInterceptor = new FileLoggingInterceptor();
    }

    private UnmarshalledFileHandlerContext createUnmarshalledFileContext(String directory, String method) {
        UnmarshalledFileHandlerContext context = new UnmarshalledFileHandlerContext();
        context.setDirectory(directory);
        context.setMethod(method);
        context.setStartTime(System.nanoTime());
        return context;
    }

}
