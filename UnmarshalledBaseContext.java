package com.cs4227.Interceptor;

import java.awt.*;

public interface UnmarshalledBaseContext {

    public String getDirectory();
    public void setDirectory(String directory);
    public String getFileName();
    public void setFileName(String fileName);
    public String getMethod();
    public void setMethod(String method);
    public long getStartTime();
    public void setStartTime(long time);
}
