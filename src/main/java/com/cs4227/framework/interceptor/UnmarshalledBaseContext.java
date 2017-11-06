package com.cs4227.framework.interceptor;

public interface UnmarshalledBaseContext {

    public String getMethod();
    public void setMethod(String method);
    public long getStartTime();
    public void setStartTime(long time);
}
