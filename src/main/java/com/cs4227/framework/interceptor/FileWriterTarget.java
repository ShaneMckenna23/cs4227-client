package com.cs4227.framework.interceptor;

import com.cs4227.ui.Start;
import com.cs4227.ui.views.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileWriterTarget implements BaseFileHandlerTarget {


    @Override
    public MarshalledFileHandlerContext execute(UnmarshalledFileHandlerContext context) {
        BufferedImage selectedFile = ImageView.selectedImage;

        return createMarshalledContext(context);
    }

    private MarshalledFileHandlerContext createMarshalledContext(UnmarshalledFileHandlerContext context) {
        MarshalledFileHandlerContext marshalledContext = new MarshalledFileHandlerContext();
        marshalledContext.setFileName(context.getFileName());
        marshalledContext.setDirectory(context.getDirectory());
        return marshalledContext;
    }
}
