package com.cs4227.interceptor;

import java.awt.*;
import java.util.GregorianCalendar;

public interface MarshalledBaseContext {

    public String getDirectory();
    public void setDirectory(String directory);
    public String getFileName();
    public void setFileName(String fileName);
    public String getMethod();
    public void setMethod(String method);
    public long getOverallTime();
    public void setOverallTime(long time);
    public boolean getOutcome();
    public void setOutcome(boolean outcome);
}
