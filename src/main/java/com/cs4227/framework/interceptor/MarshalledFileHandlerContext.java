package com.cs4227.framework.interceptor;

import java.awt.image.BufferedImage;

public class MarshalledFileHandlerContext extends MarshalledBaseContext {

    private String fileName;
    private String directory;
    private BufferedImage image;

    public String getDirectory() {
        return directory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

}



