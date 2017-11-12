package com.cs4227.framework.interceptor;

import java.util.ArrayList;

public class FileHandlerDispatcher {

    private BaseFileHandlerTarget target;

    ArrayList<BaseFileHandlerInterceptor> baseInterceptors;

    public FileHandlerDispatcher() {
        baseInterceptors = new ArrayList<>();
    }

    synchronized public void registerInterceptor(BaseFileHandlerInterceptor i) {
        baseInterceptors.add(i);
    }

    synchronized public void removeInterceptor(BaseFileHandlerInterceptor i) {
        baseInterceptors.remove(i);
    }

    public PostFileHandlerContext executeFileHandlerRequest(PreFileHandlerContext context) {
        dispatchFileHandlerInterceptorPreMarshal(context);
        PostFileHandlerContext postRequestContext = executeTarget(context);
        dispatchFileHandlerInterceptorPostMarshal(postRequestContext);
        return postRequestContext;
    }

    private void dispatchFileHandlerInterceptorPreMarshal (PreFileHandlerContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).executePreRequest(context);
        }
    }

    private void dispatchFileHandlerInterceptorPostMarshal (PostFileHandlerContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).executePostRequest(context);
        }
    }

    public void setTarget(BaseFileHandlerTarget target) {
        this.target = target;
    }

    public PostFileHandlerContext executeTarget(PreFileHandlerContext context) {
        return target.execute(context);
    }
}
