package com.cs4227.framework.interceptor;

public interface BaseDispatcher {

    public void registerInterceptor(BaseFileHandlerInterceptor i);

    public void removeInterceptor(BaseFileHandlerInterceptor i);

}
