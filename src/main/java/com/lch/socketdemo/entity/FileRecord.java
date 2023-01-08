package com.lch.socketdemo.entity;

public class FileRecord {
    private String boilerName;
    private String detectionTime;
    private String detectionDuration;
    private String videoId;
    private Integer id;

    public String getBoilerName() {
        return boilerName;
    }

    public void setBoilerName(String boilerName) {
        this.boilerName = boilerName;
    }

    public String getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(String detectionTime) {
        this.detectionTime = detectionTime;
    }

    public String getDetectionDuration() {
        return detectionDuration;
    }

    public void setDetectionDuration(String detectionDuration) {
        this.detectionDuration = detectionDuration;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FileRecord{" +
                "boilerName='" + boilerName + '\'' +
                ", detectionTime='" + detectionTime + '\'' +
                ", detectionDuration='" + detectionDuration + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
