package com.lch.socketdemo.entity;

public class Employee {
   private String eid;
   private String name;
   private Integer level;

    public String getEid() { return eid; }

    public void setEid(String eid) { this.eid = eid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getLevel() { return level; }

    public void setLevel(Integer level) { this.level = level; }

    @Override
    public String toString() {
        return "Employee{" +
                "eid='" + eid + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
