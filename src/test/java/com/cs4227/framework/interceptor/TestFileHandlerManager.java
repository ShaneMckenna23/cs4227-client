package com.cs4227.framework.interceptor;

import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static junit.framework.TestCase.assertTrue;

public class TestFileHandlerManager {

    private static final String TEST_IMAGE_DIRECTORY = System.getProperty("user.dir")
            + "\\src\\test\\resources\\imageDefault.jpg";

    private FileHandlerManager manager;

    @Before
    public void setup() {
        manager = new FileHandlerManager();
    }

    @Test
    public void testOpenAndSaveImage() throws Exception {
        System.out.println(TEST_IMAGE_DIRECTORY);
        BufferedImage image = manager.openImage(TEST_IMAGE_DIRECTORY);
        assertTrue(image != null);
        manager.saveImage(TEST_IMAGE_DIRECTORY, image);
    }

}
