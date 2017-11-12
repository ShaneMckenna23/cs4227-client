package com.cs4227.framework.interceptor;

import com.cs4227.framework.interceptor.state.StateContext;

public class PostBaseContext extends BaseContext {

    private StateContext outcomeContext;
    private long overallTime;

    public StateContext getOutcomeContext() {
        return outcomeContext;
    }

    public void setOutcomeContext(StateContext outcome) {
        this.outcomeContext = outcome;
    }

    public long getOverallTime() {
        return overallTime;
    }

    public void setOverallTime(long time) {
        this.overallTime = time;
    }

}
