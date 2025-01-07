package com.smhrd.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class postDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 게시글 작성
    public int createPost(postVO post) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.insert("com.smhrd.db.Mapper.createPost", post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 특정 모임방의 게시글 목록 조회
    public List<postVO> getPostsByParty(int partyIdx) {
        List<postVO> postList = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            postList = session.selectList("com.smhrd.db.Mapper.getPostsByParty", partyIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postList;
    }

    // 게시글 상세 조회
    public postVO getPostById(int postIdx) {
        postVO post = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            post = session.selectOne("com.smhrd.db.Mapper.getPostById", postIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    // 게시글 수정
    public int updatePost(postVO post) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.update("com.smhrd.db.Mapper.updatePost", post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 게시글 삭제
    public int deletePost(int postIdx) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.delete("com.smhrd.db.Mapper.deletePost", postIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}