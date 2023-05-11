package com.lch.socketdemo.entity;

public class Camera {
    private Integer cid;
    private String cname;
    private String ip;
    private Integer level;
    private Double locx;
    private Double locy;
    private String time;

    public Integer getCid() { return cid; }

    public void setCid(Integer cid) { this.cid = cid; }

    public String getCname() { return cname; }

    public void setCname(String cname) { this.cname = cname; }

    public String getIp() { return ip; }

    public void setIp(String ip) { this.ip = ip; }

    public Integer getLevel() { return level; }

    public void setLevel(Integer level) { this.level = level; }

    public Double getLocx() { return locx; }

    public void setLocx(Double locx) { this.locx = locx; }

    public Double getLocy() { return locy; }

    public void setLocy(Double locy) { this.locy = locy; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "Camera{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", ip='" + ip + '\'' +
                ", level=" + level +
                ", locx=" + locx +
                ", locy=" + locy +
                ", time='" + time + '\'' +
                '}';
    }
}
