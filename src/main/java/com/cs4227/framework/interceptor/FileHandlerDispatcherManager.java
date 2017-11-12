package com.cs4227.framework.interceptor;

public class FileHandlerDispatcherManager {

    private FileHandlerDispatcher dispatcher;

    public FileHandlerDispatcherManager(BaseFileHandlerTarget target) {
        dispatcher = new FileHandlerDispatcher();
        dispatcher.setTarget(target);
    }

    protected void addInterceptor(BaseFileHandlerInterceptor interceptor) {
        dispatcher.registerInterceptor(interceptor);
    }

    protected void removeInterceptor(BaseFileHandlerInterceptor interceptor) {
        dispatcher.removeInterceptor(interceptor);
    }

    public PostFileHandlerContext executeFileHandlerRequest(PreFileHandlerContext preRequestContext) {
        return dispatcher.executeFileHandlerRequest(preRequestContext);
    }

}
