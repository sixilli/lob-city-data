package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponse<T> {
    private String get;
    private String[] parameters;
    private String[] errors;
    private int results;
    private List<T> response;

    @JsonCreator
    public ApiResponse(
            @JsonProperty("get") String get,
            @JsonProperty("parameters") String[] parameters,
            @JsonProperty("errors") String[] errors,
            @JsonProperty("results") int results,
            @JsonProperty("response") List<T> response
    ) {
        this.get = get;
        this.parameters = parameters;
        this.results = results;
        this.response = response;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public String[] getParameters() {
        return parameters;
    }

    public List<T> getResponse() {
        return response;
    }

    public void setParameters(String[] parameters) {
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

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }
}
