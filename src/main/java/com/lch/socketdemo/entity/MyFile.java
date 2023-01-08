package com.lch.socketdemo.entity;

public class MyFile {
    private Integer id;
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
