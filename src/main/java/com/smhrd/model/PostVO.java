package com.smhrd.model;

public class PostVO {
    private int postIdx;
    private String postNm;
    private String postContent;
    private String postFile;
    private int postViews;
    private int postLike;
    private String createdAt;
    private String userId; // 작성자 ID
    private int partyIdx;  // 모임 방 ID

    public PostVO(String postNm, String postContent, String postFile, String userId, int partyIdx) {
        this.postNm = postNm;
        this.postContent = postContent;
        this.postFile = postFile;
        this.userId = userId;
        this.partyIdx = partyIdx;
    }

    // 기본 생성자, getter, setter 추가
    public PostVO() {}

    public int getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(int postIdx) {
        this.postIdx = postIdx;
    }

    public String getPostNm() {
        return postNm;
    }

    public void setPostNm(String postNm) {
        this.postNm = postNm;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostFile() {
        return postFile;
    }

    public void setPostFile(String postFile) {
        this.postFile = postFile;
    }

    public int getPostViews() {
        return postViews;
    }

    public void setPostViews(int postViews) {
        this.postViews = postViews;
    }

    public int getPostLike() {
        return postLike;
    }

    public void setPostLike(int postLike) {
        this.postLike = postLike;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPartyIdx() {
        return partyIdx;
    }

    public void setPartyIdx(int partyIdx) {
        this.partyIdx = partyIdx;
    }
}