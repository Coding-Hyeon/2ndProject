package com.smhrd.model;

import java.util.ArrayList;
import java.util.List;

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
    public List<PostVO> selectLatestPostsByParty(int partyIdx) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        List<PostVO> postList = null;
        try {
            postList = session.selectList("com.smhrd.db.Mapper.selectLatestPostsByParty", partyIdx);
        } finally {
            session.close();
        }
        return postList;
    }
    
    public int insertParty(PartyVO party) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.insert("com.smhrd.db.Mapper.insertParty", party);
        } finally {
            session.close();
        }
        return cnt;
    }
    public List<PostVO> getPostsByPartyIdx(int partyIdx) {
        List<PostVO> posts = new ArrayList<>();
        try (SqlSession session = (SqlSession) SqlSessionManager.getSqlSession()) {
            posts = session.selectList("PostMapper.getPostsByPartyIdx", partyIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
    
    public PostVO getPostById(int postIdx) {
        PostVO post = null;
        try (SqlSession session = (SqlSession) SqlSessionManager.getSqlSession()) {
            post = session.selectOne("PostMapper.getPostById", postIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
        
        
    }
    
    
}