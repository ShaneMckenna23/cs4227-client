package com.cs4227.framework.interceptor;

public interface BaseFileHandlerInterceptor {

    public void executePreRequest(PreFileHandlerContext context);

    public void executePostRequest(PostFileHandlerContext context);
}
