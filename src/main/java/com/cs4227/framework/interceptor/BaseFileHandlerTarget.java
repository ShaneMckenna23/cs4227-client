package com.cs4227.framework.interceptor;

public interface BaseFileHandlerTarget {

    public PostFileHandlerContext execute(PreFileHandlerContext context);
}
