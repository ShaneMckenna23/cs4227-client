package com.cs4227.Interceptor;

public interface BaseInterceptor {

    public void onPreMarshalRequest (UnmarshalledBaseContext context);

    public void onPostMarshalRequest (MarshalledBaseContext context);
}
