package com.cs4227.framework.interceptor;

public class FileWriterTarget implements BaseFileHandlerTarget {


    @Override
    public MarshalledFileHandlerContext execute(UnmarshalledFileHandlerContext context) {
        //todo
        return createMarshalledContext(context);
    }

    private MarshalledFileHandlerContext createMarshalledContext(UnmarshalledFileHandlerContext context) {
        MarshalledFileHandlerContext marshalledContext = new MarshalledFileHandlerContext();
        marshalledContext.setFileName(context.getFileName());
        marshalledContext.setDirectory(context.getDirectory());
        return marshalledContext;
    }
}
