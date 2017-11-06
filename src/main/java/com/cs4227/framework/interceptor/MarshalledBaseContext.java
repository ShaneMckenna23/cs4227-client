package com.cs4227.framework.interceptor;

public interface MarshalledBaseContext {

    public String getMethod();
    public void setMethod(String method);
    public long getOverallTime();
    public void setOverallTime(long time);
    public boolean getOutcome();
    public void setOutcome(boolean outcome);
}
