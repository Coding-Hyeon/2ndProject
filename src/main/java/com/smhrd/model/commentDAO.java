package com.smhrd.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class commentDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 댓글 작성
    public int createComment(commentVO comment) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.insert("com.smhrd.db.Mapper.createComment", comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 특정 게시글의 댓글 목록 조회
    public List<commentVO> getCommentsByPost(int postIdx) {
        List<commentVO> commentList = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            commentList = session.selectList("com.smhrd.db.Mapper.getCommentsByPost", postIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentList;
    }

    // 댓글 삭제
    public int deleteComment(int commentIdx) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.delete("com.smhrd.db.Mapper.deleteComment", commentIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
