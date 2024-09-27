package com.test.Responses.pojo;


public class Base {
    public String id;
    public String name;
    public Attributes Attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes getData() {
        return Attributes;
    }

    public void setData(Attributes attributes) {
        this.Attributes = attributes;
    }

}
