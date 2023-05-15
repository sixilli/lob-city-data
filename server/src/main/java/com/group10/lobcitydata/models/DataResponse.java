package com.group10.lobcitydata.models;

import org.springframework.http.HttpStatusCode;

/*
    2.2.2 Response formats for normal data and errors
*/
public class DataResponse<T> {
    public T data;
    public int statusCode;

    public DataResponse(T data, HttpStatusCode status) {
        this.data = data;
        this.statusCode = status.value();
    }
}
