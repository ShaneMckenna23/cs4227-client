package com.cs4227.framework.interceptor;

import java.awt.image.BufferedImage;

public class MarshalledFileHandlerContext implements MarshalledBaseContext {

    private long startTime;
    private String fileName;
    private String directory;
    private String method;
    private boolean outcome;
    private long time;
    private BufferedImage image;


    public MarshalledFileHandlerContext() {
        startTime = System.nanoTime();
    }


    public String getDirectory() {
        return directory;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String getMethod() {
        return method;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

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

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
}
