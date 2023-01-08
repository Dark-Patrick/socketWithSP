package com.lch.socketdemo.entity;

public class Model {
    private Integer id;
    private String category;
    private String cl;
    private String des;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getCl() { return cl; }

    public void setCl(String cl) { this.cl = cl; }

    public String getDes() { return des; }

    public void setDes(String des) { this.des = des; }

    @Override
    public String toString() {
        return "model{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", cl='" + cl + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
