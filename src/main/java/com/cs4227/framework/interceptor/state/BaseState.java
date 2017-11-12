package com.cs4227.framework.interceptor.state;

public interface BaseState {

    public void toggle(StateContext context);
    public String stateMessage();

}
