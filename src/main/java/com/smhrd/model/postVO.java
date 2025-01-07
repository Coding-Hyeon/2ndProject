package com.smhrd.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class postVO {
    private int postIdx;
    private String postNm;
    private String postContent;
    private String postFile;
    private int postViews;
    private int postLike;
    private Timestamp createdAt;
    private String userId;
    private int partyIdx; 
}