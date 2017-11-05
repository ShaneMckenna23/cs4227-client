package com.cs4227.interceptor;

public interface BaseDispatcher {

    public void registerFileHandlerInterceptor (BaseInterceptor i);

    public void removeFileHandlerInterceptor (BaseInterceptor i);

    public void dispatchFileHandlerInterceptorPreMarshal (UnmarshalledBaseContext context);

    public void dispatchFileHandlerInterceptorPostMarshal (MarshalledBaseContext context);

    public void setTarget(BaseTarget target);

    public MarshalledBaseContext executeTarget(UnmarshalledBaseContext context);
}
