package com.cs4227.framework.interceptor.state;

public class StateContext {

    private BaseState state;
    private String creatorClass;

    public StateContext(){
        state = null;
    }

    public void setState(BaseState state){
        this.state = state;
    }

    public BaseState getState(){
        return state;
    }

    public void setCreatorClass(String creatorClass) {
        this.creatorClass = creatorClass;
    }

    public String getCreatorClass() {
        return creatorClass;
    }
}
