package com.cs4227.framework.interceptor;

public class MarshalledBaseContext extends BaseContext {

    private boolean outcome;
    private long overallTime;

    public boolean getOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public long getOverallTime() {
        return overallTime;
    }

    public void setOverallTime(long time) {
        this.overallTime = time;
    }

}
