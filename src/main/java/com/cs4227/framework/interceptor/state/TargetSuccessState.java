package com.cs4227.framework.interceptor.state;

public class TargetSuccessState implements BaseState {

    private static final String SUCCESS_MESSAGE = "Success";

    public void toggle(StateContext context) {
        context.setState(this);
    }

    public String stateMessage(){
        return SUCCESS_MESSAGE;
    }
}
