package com.cs4227.interceptor;

public interface BaseTarget {
    public MarshalledBaseContext execute(UnmarshalledBaseContext context);
}
