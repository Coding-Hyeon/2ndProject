package com.smhrd.model;

public class CommentVO {
    private int cmtIdx;
    private String cmtContent;
    private int cmtLikes;
    private String createdAt;
    private String userId; // 댓글 작성자 ID
    private int postIdx;   // 댓글이 달린 게시글 ID

    public CommentVO(String cmtContent, String userId, int postIdx) {
        this.cmtContent = cmtContent;
        this.userId = userId;
        this.postIdx = postIdx;
    }

    // 기본 생성자, getter, setter 추가
    public CommentVO() {}

    public int getCmtIdx() {
        return cmtIdx;
    }

    public void setCmtIdx(int cmtIdx) {
        this.cmtIdx = cmtIdx;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public int getCmtLikes() {
        return cmtLikes;
    }

    public void setCmtLikes(int cmtLikes) {
        this.cmtLikes = cmtLikes;
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

    public int getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(int postIdx) {
        this.postIdx = postIdx;
    }
}