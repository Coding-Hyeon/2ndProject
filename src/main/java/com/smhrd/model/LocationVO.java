package com.smhrd.model;

public class LocationVO {
    private String l_post_nm; // 제목
    private String l_post_content; // 내용
    private double latitude; // 위도
    private double longitude; // 경도

    // Getter & Setter
    public String getL_post_nm() {
        return l_post_nm;
    }

    public void setL_post_nm(String l_post_nm) {
        this.l_post_nm = l_post_nm;
    }

    public String getL_post_content() {
        return l_post_content;
    }

    public void setL_post_content(String l_post_content) {
        this.l_post_content = l_post_content;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
