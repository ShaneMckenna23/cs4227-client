package com.cs4227.interceptor;

import java.awt.*;
import java.util.GregorianCalendar;

public class MarshalledFileLoggingContext implements MarshalledBaseContext {

    private long startTime;
    private String fileName;
    private String directory;
    private String method;
    private boolean outcome;
    private long time;


    public MarshalledFileLoggingContext() {
        startTime = System.nanoTime();
    }


    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public void setDirectory(String directory) {

    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean getOutcome() {
        return outcome;
    }

    @Override
    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    @Override
    public long getOverallTime() {
        return time;
    }

    @Override
    public void setOverallTime(long time) {
        this.time = time;
    }
}
