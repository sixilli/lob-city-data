package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public class ApiResponse<T> {
    private String get;
    @JsonDeserialize(using = ApiResponseDeserializer.class)
    private String parameters;
    @JsonDeserialize(using = ApiResponseDeserializer.class)
    private String errors;
    private int results;
    private List<T> response;

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public String getParameters() {
        return parameters;
    }

    public List<T> getResponse() {
        return response;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public void setResponse(List<T> response) {
        this.response = response;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
