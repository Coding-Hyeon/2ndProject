package com.smhrd.model;

import java.sql.Timestamp;

public class partyVO {
    private int partyIdx;
    private String partyNm;
    private String partyInfo;
    private String partyRegion;
    private String partyFile;
    private Timestamp createdAt;
    private String userId;

    // 기본 생성자
    public partyVO() {}

    // 모든 필드를 포함한 생성자
    public partyVO(int partyIdx, String partyNm, String partyInfo, String partyRegion, String partyFile, Timestamp createdAt, String userId) {
        this.partyIdx = partyIdx;
        this.partyNm = partyNm;
        this.partyInfo = partyInfo;
        this.partyRegion = partyRegion;
        this.partyFile = partyFile;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    // Getter & Setter
    public int getPartyIdx() { return partyIdx; }
    public void setPartyIdx(int partyIdx) { this.partyIdx = partyIdx; }

    public String getPartyNm() { return partyNm; }
    public void setPartyNm(String partyNm) { this.partyNm = partyNm; }

    public String getPartyInfo() { return partyInfo; }
    public void setPartyInfo(String partyInfo) { this.partyInfo = partyInfo; }

    public String getPartyRegion() { return partyRegion; }
    public void setPartyRegion(String partyRegion) { this.partyRegion = partyRegion; }

    public String getPartyFile() { return partyFile; }
    public void setPartyFile(String partyFile) { this.partyFile = partyFile; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}

