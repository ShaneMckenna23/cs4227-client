package com.cs4227.framework.filters;

import java.awt.image.BufferedImage;

public interface Filter {
    BufferedImage convert(BufferedImage image);
}
