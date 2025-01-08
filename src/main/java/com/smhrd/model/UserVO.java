package com.smhrd.model;

public class UserVO {
    private String userId;
    private String userPw;
    private String userName;
    private String userGender;
    private String userAge;
    private String userRegion;

    public UserVO(String userId, String userPw, String userName, String userGender, String userAge, String userRegion) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userRegion = userRegion;
    }
    
    public UserVO(String userId, String userPw, String userName, String userRegion) {
    	this.userId = userId;
    	this.userPw = userPw;
    	this.userName = userName;
    	this.userRegion = userRegion;
    }

    // Getter and Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }
}
