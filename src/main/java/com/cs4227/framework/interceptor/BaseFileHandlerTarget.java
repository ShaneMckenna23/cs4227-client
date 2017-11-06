package com.cs4227.framework.interceptor;

public interface BaseFileHandlerTarget {

    public MarshalledFileHandlerContext execute(UnmarshalledFileHandlerContext context);

}
