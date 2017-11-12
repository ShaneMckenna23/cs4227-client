package com.cs4227.framework.interceptor.state;

import com.cs4227.framework.interceptor.FileHandlerDispatcherManager;
import com.cs4227.framework.interceptor.FileLoggingInterceptor;
import org.apache.log4j.Logger;

public class LoggingDisableState implements BaseState {

    private static final String DISABLED_MESSAGE = "Logging has been disabled.";
    private static final String DISABLED_LOG_MESSAGE = "Logging has been disabled for class: ";

    private FileHandlerDispatcherManager manager;
    private FileLoggingInterceptor interceptor;
    private LoggingEnableState enableState;
    private Logger logger = Logger.getLogger(LoggingDisableState.class);

    public LoggingDisableState(FileLoggingInterceptor interceptor, FileHandlerDispatcherManager manager) {
        this.interceptor = interceptor;
        this.manager = manager;
    }

    public void toggle(StateContext context) {
        logger.info(DISABLED_LOG_MESSAGE + context.getCreatorClass());
        manager.removeInterceptor(interceptor);
        context.setState(enableState);
    }

    public void setEnableState(LoggingEnableState enableState) {
        this.enableState = enableState;
    }

    public String stateMessage() {
        return DISABLED_MESSAGE;
    }
}
