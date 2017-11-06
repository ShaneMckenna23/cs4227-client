package com.cs4227.framework.interceptor;

import java.util.ArrayList;

public class FileHandlerDispatcher {

    private BaseFileHandlerTarget target;

    ArrayList<BaseFileHandlerInterceptor> baseInterceptors;

    synchronized public void registerInterceptor(BaseFileHandlerInterceptor i) {
        baseInterceptors.add(i);
    }

    synchronized public void removeInterceptor(BaseFileHandlerInterceptor i) {
        baseInterceptors.remove(i);
    }

    public MarshalledFileHandlerContext executeFileHandlerRequest(UnmarshalledFileHandlerContext context) {
        dispatchFileHandlerInterceptorPreMarshal(context);
        MarshalledFileHandlerContext marshalledContext = executeTarget(context);
        dispatchFileHandlerInterceptorPostMarshal(marshalledContext);
        return marshalledContext;
    }

    private void dispatchFileHandlerInterceptorPreMarshal (UnmarshalledFileHandlerContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).onPreMarshalRequest(context);
        }
    }

    private void dispatchFileHandlerInterceptorPostMarshal (MarshalledFileHandlerContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).onPostMarshalRequest(context);
        }
    }

    public void setTarget(BaseFileHandlerTarget target) {
        this.target = target;
    }

    public MarshalledFileHandlerContext executeTarget(UnmarshalledFileHandlerContext context) {
        return target.execute(context);
    }
}
