package com.cs4227.framework.interceptor.state;

public interface BaseDualState extends BaseState {

    public void setAlternateState(BaseDualState state);
}
