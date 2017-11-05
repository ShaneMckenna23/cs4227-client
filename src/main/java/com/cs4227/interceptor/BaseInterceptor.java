package com.cs4227.interceptor;

public interface BaseInterceptor {

    public void onPreMarshalRequest (UnmarshalledBaseContext context);

    public void onPostMarshalRequest (MarshalledBaseContext context);
}
