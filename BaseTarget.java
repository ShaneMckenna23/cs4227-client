package com.cs4227.Interceptor;

public interface BaseTarget {
    public MarshalledBaseContext execute(UnmarshalledBaseContext context);
}
