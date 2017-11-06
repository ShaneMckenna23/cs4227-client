package com.cs4227.framework.interceptor;

import org.apache.log4j.Logger;

public class FileLoggingInterceptor implements BaseFileHandlerInterceptor {

    private Logger logger = Logger.getLogger(FileLoggingInterceptor.class);

    @Override
    public void onPreMarshalRequest(UnmarshalledFileHandlerContext context) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("Executing method " + context.getMethod() + " to obtain image from directory: "
                + context.getDirectory());
        logger.info(logInfo);
    }

    @Override
    public void onPostMarshalRequest(MarshalledFileHandlerContext context) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("Method " + context.getMethod() + " execution was ");
        String outcome = (context.getOutcome() == false) ? "unsuccessful." : "successful.";
        logInfo.append(outcome);
        logInfo.append(" Time spent: " + context.getOverallTime() / 1000000000.0);
        logger.info(logInfo);
    }

}
