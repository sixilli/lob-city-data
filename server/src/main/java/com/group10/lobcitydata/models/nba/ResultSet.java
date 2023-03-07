package com.group10.lobcitydata.models.nba;

import java.util.List;

public class ResultSet<T> {
    public String name;
    public List<String> headers;
    public List<T> rowSet;
}
