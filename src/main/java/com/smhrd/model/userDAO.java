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
    
    // 회원 정보 업데이트 메서드
    public int updateUser(userVO user) {
        SqlSession session = factory.openSession();
        int result = 0;

        try {
            result = session.update("com.smhrd.db.Mapper.updateUser", user);
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
    
    // 회원 탈퇴 메서드
    public int deleteUser(String id) {
        SqlSession session = factory.openSession();
        int result = 0;

        try {
            result = session.delete("com.smhrd.db.Mapper.deleteUser", id);
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

    // 이름 중복 체크 메서드
    public boolean isNameDuplicated(String name) {
        SqlSession session = factory.openSession();
        boolean isDuplicated = false;

        try {
            int count = session.selectOne("com.smhrd.db.Mapper.checkNameDuplicate", name);
            isDuplicated = count > 0;
        } finally {
            session.close();
        }

        return isDuplicated;
    }
}