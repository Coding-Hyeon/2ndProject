package com.smhrd.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionManager {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml"; // MyBatis 설정 파일 경로
            InputStream inputStream = SqlSessionManager.class.getClassLoader().getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing SqlSessionFactory", e);
        }
    }

    public static SqlSessionFactory getSqlSession() {
        return sqlSessionFactory;
    }
}
