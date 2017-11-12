package com.cs4227.framework.interceptor.state;

import org.apache.log4j.Logger;

public class LoggingDisabledState implements BaseState {

    private static final String DISABLED_MESSAGE = "Logging has been disabled.";
    private static final String DISABLED_LOG_MESSAGE = "Logging has been disabled for class: ";

    private Logger logger = Logger.getLogger(LoggingDisabledState.class);

    public void toggle(StateContext context) {
        logger.info(DISABLED_LOG_MESSAGE + context.getCreatorClass());
        context.setState(this);
    }

    public String stateMessage() {
        return DISABLED_MESSAGE;
    }
}
