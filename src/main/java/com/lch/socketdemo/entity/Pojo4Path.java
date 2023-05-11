package com.lch.socketdemo.entity;

public class Pojo4Path {
    private String name;
    private String cname;
    private Double locx;
    private Double locy;
    private String des;
    private String time;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCname() { return cname; }

    public void setCname(String cname) { this.cname = cname; }

    public Double getLocx() { return locx; }

    public void setLocx(Double locx) { this.locx = locx; }

    public Double getLocy() { return locy; }

    public void setLocy(Double locy) { this.locy = locy; }

    public String getDes() { return des; }

    public void setDes(String des) { this.des = des; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "Pojo4Path{" +
                "name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", locx=" + locx +
                ", locy=" + locy +
                ", des='" + des + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
