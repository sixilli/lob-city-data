package com.group10.lobcitydata.models;

import org.springframework.http.HttpStatusCode;

public class DataResponse<T> {
    public T data;
    public int statusCode;

    public DataResponse(T data, HttpStatusCode status) {
        this.data = data;
        this.statusCode = status.value();
    }
}
