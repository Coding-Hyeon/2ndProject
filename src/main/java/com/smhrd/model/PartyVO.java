package com.smhrd.model;

public class PartyVO {
    private int partyIdx;
    private String partyNm;
    private String partyInfo;
    private String partyRegion;
    private String partyFile;
    private int memberCount;
    private String userId; // 방장 ID
    private String createdAt;

    public PartyVO(int partyIdx, String partyNm, String partyInfo, String partyRegion, String partyFile, String createdAt, String userId) {
        this.partyIdx = partyIdx;
        this.partyNm = partyNm;
        this.partyInfo = partyInfo;
        this.partyRegion = partyRegion;
        this.partyFile = partyFile;
        this.createdAt = createdAt;
        this.userId = userId;
    }
    
    public PartyVO(int partyIdx, String partyNm, String partyInfo, String partyRegion, String partyFile, int memberCount, String userId, String createdAt) {
        this.partyIdx = partyIdx;
        this.partyNm = partyNm;
        this.partyInfo = partyInfo;
        this.partyRegion = partyRegion;
        this.partyFile = partyFile;
        this.memberCount = memberCount;
        this.userId = userId;
        this.createdAt = createdAt;
    }
    
    public PartyVO(String partyNm, String partyInfo, String partyRegion, String partyFile, String userId) {
        this.partyNm = partyNm;
        this.partyInfo = partyInfo;
        this.partyRegion = partyRegion;
        this.partyFile = partyFile;
        this.userId = userId;
    }
    
    public PartyVO(int partyIdx, String partyNm, String partyInfo, String partyRegion, String partyFile, String userId) {
        this.partyIdx = partyIdx;
        this.partyNm = partyNm;
        this.partyInfo = partyInfo;
        this.partyRegion = partyRegion;
        this.partyFile = partyFile;
        this.userId = userId;
    }

    // 기본 생성자, getter, setter 추가
    public PartyVO() {}

    public int getPartyIdx() {
        return partyIdx;
    }

    public void setPartyIdx(int partyIdx) {
        this.partyIdx = partyIdx;
    }

    public String getPartyNm() {
        return partyNm;
    }

    public void setPartyNm(String partyNm) {
        this.partyNm = partyNm;
    }

    public String getPartyInfo() {
        return partyInfo;
    }

    public void setPartyInfo(String partyInfo) {
        this.partyInfo = partyInfo;
    }

    public String getPartyRegion() {
        return partyRegion;
    }

    public void setPartyRegion(String partyRegion) {
        this.partyRegion = partyRegion;
    }

    public String getPartyFile() {
        return partyFile;
    }

    public void setPartyFile(String partyFile) {
        this.partyFile = partyFile;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
