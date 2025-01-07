package com.smhrd.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class joiningVO {
    private int joinIdx; // PK
    private int partyIdx; // 모임방 ID (FK)
    private String userId; // 사용자 ID (FK)
    private String joinIntro; // 가입 소개글
    private char agreeYn; // 가입 상태 ('Y' 또는 'N')
    private Timestamp joinedAt; // 가입 신청 날짜

    // 기본 생성자
    public joiningVO() {}

    // 모든 필드를 포함한 생성자
    public joiningVO(int joinIdx, int partyIdx, String userId, String joinIntro, char agreeYn, Timestamp joinedAt) {
        this.joinIdx = joinIdx;
        this.partyIdx = partyIdx;
        this.userId = userId;
        this.joinIntro = joinIntro;
        this.agreeYn = agreeYn;
        this.joinedAt = joinedAt;
    }

    // Getter & Setter
    public int getJoinIdx() { return joinIdx; }
    public void setJoinIdx(int joinIdx) { this.joinIdx = joinIdx; }

    public int getPartyIdx() { return partyIdx; }
    public void setPartyIdx(int partyIdx) { this.partyIdx = partyIdx; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getJoinIntro() { return joinIntro; }
    public void setJoinIntro(String joinIntro) { this.joinIntro = joinIntro; }

    public char getAgreeYn() { return agreeYn; }
    public void setAgreeYn(char agreeYn) { this.agreeYn = agreeYn; }

    public Timestamp getJoinedAt() { return joinedAt; }
    public void setJoinedAt(Timestamp joinedAt) { this.joinedAt = joinedAt; }
}
