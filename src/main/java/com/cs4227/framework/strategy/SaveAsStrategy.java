package com.cs4227.framework.strategy;

import com.cs4227.framework.state.StateContext;

import java.awt.image.BufferedImage;

public interface SaveAsStrategy {
    public void save(String destination, BufferedImage image, StateContext context);
}
