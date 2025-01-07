package com.smhrd.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class commentVO {
    private int commentIdx;
    private int postIdx;
    private String content;
    private Timestamp createdAt;
    private String userId;
}