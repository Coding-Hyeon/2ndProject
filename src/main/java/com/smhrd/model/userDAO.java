package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class userDAO {
    private SqlSessionFactory factory = SqlSessionManager.getSqlSession();
    
    // 회원가입 매서드
    public int insertUser(userVO user) {
        SqlSession session = factory.openSession();
        int result = 0;

        try {
            result = session.insert("com.smhrd.db.Mapper.insertUser", user);
            if (result > 0) {
                session.commit();
            } else {
                session.rollback();
            }
        } finally {
            session.close();
        }

        return result;
    }
    
    // 로그인 메서드
    public userVO login(String id, String pw) {
		SqlSession session = factory.openSession();
        userVO user = null;

        try {
            // MyBatis Mapper 호출
            user = session.selectOne("com.smhrd.db.Mapper.login", new userVO(id, pw, null, '\0', null, null, null));
        } finally {
            session.close();
        }
        return user;
    }
}