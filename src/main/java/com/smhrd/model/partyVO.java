package com.smhrd.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class partyVO {
    private int party_idx;
    private String party_nm;
    private String party_info;
    private String party_region;
    private String party_file;
    private Timestamp createdAt;
    private String id;
}

