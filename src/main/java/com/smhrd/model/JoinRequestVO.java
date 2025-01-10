package com.smhrd.model;

public class JoinRequestVO {
    private String userId;
    private int partyIdx;
    private String joinIntro;
    private char agreeYn;

    public JoinRequestVO(String userId, int partyIdx, String joinIntro, char agreeYn) {
        this.userId = userId;
        this.partyIdx = partyIdx;
        this.joinIntro = joinIntro;
        this.agreeYn = agreeYn;
    }

    // Getter와 Setter 추가
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getPartyIdx() { return partyIdx; }
    public void setPartyIdx(int partyIdx) { this.partyIdx = partyIdx; }

    public String getJoinIntro() { return joinIntro; }
    public void setJoinIntro(String joinIntro) { this.joinIntro = joinIntro; }
    
    public char getAgreeYn() { return agreeYn; }
    public void setAgreeYn(char agreeYn) { this.agreeYn = agreeYn; }
}