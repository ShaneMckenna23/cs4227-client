package com.cs4227.framework.interceptor.state;

public class TargetFailureState implements BaseState {

    private static final String FAILURE_MESSAGE = "Failed";

    public void toggle(StateContext context) {
        context.setState(this);
    }

    public String stateMessage(){
        return FAILURE_MESSAGE;
    }
}
