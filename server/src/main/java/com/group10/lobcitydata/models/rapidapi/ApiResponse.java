package com.group10.lobcitydata.models.rapidapi;

import java.util.List;
import java.util.Map;

public class ApiResponse<T> {
    private String get;
    private Map<String, String> parameters;
    private String[] errors;
    private int results;
    private List<T> response;

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public List<T> getResponse() {
        return response;
    }

    public void setParameters(Map<String, String> parameters) {
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
