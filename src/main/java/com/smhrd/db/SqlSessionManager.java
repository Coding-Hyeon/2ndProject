package com.smhrd.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	// DB의 기본 정보(driver,url,id,pw)을 가지고 여러개의 SqlSession을 생성 할 수 있는 sqlSessionFactory를 생성하고 관리 할 수 있는 클래스
	
	// 서버가 실행 될 때 딱 한번 읽고 사용 -> static{} : main()이 시작되지마자 같이 호출될 수 있는 구조
	static SqlSessionFactory sqlSessionFactory;
	static {
		// try-catch : (문법 오류가 아닌) 문자열 오류가 발생 할 수 있을 때 사용54
		try {
			String resource = "com/smhrd/db/mybatis-config.xml"; 
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	//다른 클래에서 해당 sqlSessionFactory를 호출할 수 있는 메소드 생성
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
