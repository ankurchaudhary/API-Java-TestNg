package com.test.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.testdata.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    public String name;
    public String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
