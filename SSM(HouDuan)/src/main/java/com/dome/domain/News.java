package com.dome.domain;

import org.springframework.stereotype.Component;

@Component
public class News {
    private String id;
    private String auther;
    private String date;
    private String conter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    @Override
    public String toString() {
        return "News:{" +
                "id='" + id + '\'' +
                ", auther='" + auther + '\'' +
                ", date='" + date + '\'' +
                ", conter='" + conter + '\'' +
                '}';
    }
}
