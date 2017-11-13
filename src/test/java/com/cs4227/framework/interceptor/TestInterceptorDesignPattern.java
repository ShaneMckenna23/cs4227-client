package com.cs4227.framework.interceptor;

import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestInterceptorDesignPattern {

    private static final String TEST_IMAGE_DIRECTORY = System.getProperty("user.dir")
            + "/src/test/resources/imageDefault.jpg";
    private static final String SAVE_SUCCESSFUL = "Success.";

    private FileHandlerManager manager;

    @Before
    public void setup() {
        manager = new FileHandlerManager();
    }

    @Test
    public void testOpenAndSaveImage() throws Exception {
        BufferedImage image = manager.openImage(TEST_IMAGE_DIRECTORY);
        assertTrue(image != null);
        String outcome = manager.saveImage(TEST_IMAGE_DIRECTORY, image);
        assertEquals(SAVE_SUCCESSFUL, outcome);
    }

}
