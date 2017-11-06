package com.cs4227.framework.interceptor;

public interface BaseFileHandlerInterceptor {

    public void onPreMarshalRequest (UnmarshalledFileHandlerContext context);

    public void onPostMarshalRequest (MarshalledFileHandlerContext context);
}
