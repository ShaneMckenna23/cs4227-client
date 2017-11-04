package com.cs4227.Interceptor;

import org.apache.log4j.Logger;

public class FileLoggingInterceptor implements BaseInterceptor {

    private Logger logger = Logger.getLogger(FileLoggingInterceptor.class);

    @Override
    public void onPreMarshalRequest(UnmarshalledBaseContext context) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("Executing method " + context.getMethod() + " to obtain image from directory: "
                + context.getDirectory());
        logger.info(logInfo);
    }

    @Override
    public void onPostMarshalRequest(MarshalledBaseContext context) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("Method " + context.getMethod() + " execution was ");
        String outcome = (context.getOutcome() == false) ? "unsuccessful." : "successful.";
        logInfo.append(outcome);
        logInfo.append(" Time spent: " + context.getOverallTime() / 1000000000.0);
        logger.info(logInfo);
    }

}
