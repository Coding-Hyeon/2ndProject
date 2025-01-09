package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class PostDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 게시글 생성
    public int insertPost(PostVO post) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.insert("com.smhrd.db.Mapper.insertPost", post);
        } finally {
            session.close();
        }
        return cnt;
    }
    
    // 게시글 수정
    public int updatePost(PostVO post) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.update("com.smhrd.db.Mapper.updatePost", post);
        } finally {
            session.close();
        }
        return cnt;
    }

    // 게시글 삭제
    public int deletePost(int postIdx) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.delete("com.smhrd.db.Mapper.deletePost", postIdx);
        } finally {
            session.close();
        }
        return cnt;
    }
}