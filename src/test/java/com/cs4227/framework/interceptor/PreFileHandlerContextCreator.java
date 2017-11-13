package com.cs4227.framework.interceptor;

public class PreFileHandlerContextCreator {

    public PreFileHandlerContext createPreFileHandlerContext(String directory) {
        PreFileHandlerContext context = new PreFileHandlerContext();
        context.setDirectory(directory);
        context.setStartTime(System.nanoTime());
        return context;
    }

}
