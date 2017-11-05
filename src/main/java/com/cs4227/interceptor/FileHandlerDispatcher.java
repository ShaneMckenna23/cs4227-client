package com.cs4227.interceptor;

import java.util.ArrayList;

public class FileHandlerDispatcher implements BaseDispatcher {

    private BaseTarget target;

    ArrayList<BaseInterceptor> baseInterceptors;


    public FileHandlerDispatcher() {
        baseInterceptors = new ArrayList<BaseInterceptor>();
    }

    synchronized public void registerFileHandlerInterceptor (BaseInterceptor i) {
        baseInterceptors.add(i);
    }

    synchronized public void removeFileHandlerInterceptor (BaseInterceptor i) {
        baseInterceptors.remove(i);
    }

    public void dispatchFileHandlerInterceptorPreMarshal (UnmarshalledBaseContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).onPreMarshalRequest(context);
        }
        MarshalledBaseContext marshalledContext = executeTarget(context);
        dispatchFileHandlerInterceptorPostMarshal(marshalledContext);

    }

    public void dispatchFileHandlerInterceptorPostMarshal (MarshalledBaseContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).onPostMarshalRequest(context);
        }
    }

    @Override
    public void setTarget(BaseTarget target) {
        this.target = target;
    }

    @Override
    public MarshalledBaseContext executeTarget(UnmarshalledBaseContext context) {
        return target.execute(context);
    }
}
