package com.cs4227.framework.interceptor;

import java.awt.image.BufferedImage;

public class PreFileHandlerContext extends PreBaseContext {

    private String directory;
    private BufferedImage image;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
}


