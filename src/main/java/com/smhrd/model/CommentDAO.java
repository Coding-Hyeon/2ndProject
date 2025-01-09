package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class CommentDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 댓글 생성
    public int insertComment(CommentVO comment) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.insert("com.smhrd.db.Mapper.insertComment", comment);
        } finally {
            session.close();
        }
        return cnt;
    }
    
    // 댓글 수정
    public int updateComment(CommentVO comment) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.update("com.smhrd.db.Mapper.updateComment", comment);
        } finally {
            session.close();
        }
        return cnt;
    }

    // 댓글 삭제
    public int deleteComment(int cmtIdx) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.delete("com.smhrd.db.Mapper.deleteComment", cmtIdx);
        } finally {
            session.close();
        }
        return cnt;
    }
}