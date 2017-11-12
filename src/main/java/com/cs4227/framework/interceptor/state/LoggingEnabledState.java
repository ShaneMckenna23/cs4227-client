package com.cs4227.framework.interceptor.state;

import org.apache.log4j.Logger;

public class LoggingEnabledState implements BaseState {

    private static final String ENABLED_MESSAGE = "Logging has been enabled.";
    private static final String ENABLED_LOG_MESSAGE = "Logging has been enabled for class: ";

    private Logger logger = Logger.getLogger(LoggingEnabledState.class);

    public void toggle(StateContext context) {
        logger.info(ENABLED_LOG_MESSAGE + context.getCreatorClass());
        context.setState(this);
    }

    public String stateMessage() {
        return ENABLED_MESSAGE;
    }
}
