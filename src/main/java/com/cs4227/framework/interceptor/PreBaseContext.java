package com.cs4227.framework.interceptor;

public class PreBaseContext extends BaseContext {

    private long startTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long time) {
        this.startTime = time;
    }

}