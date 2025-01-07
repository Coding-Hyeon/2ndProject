package com.smhrd.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class userVO {
	private String id;
	private String pw;
	private String name;
	private char gender;
	private LocalDate date;
	private String region;
	private LocalDateTime time;

}
