package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class joiningDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 모임방에 가입 여부 확인
    public joiningVO checkJoiningStatus(int partyIdx, String userId) {
        joiningVO result = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            result = session.selectOne("com.smhrd.db.Mapper.checkJoiningStatus", new joiningVO(0, partyIdx, userId, null, 'N', null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 가입 신청
    public int applyJoining(joiningVO joining) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.insert("com.smhrd.db.Mapper.applyJoining", joining);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 가입 신청 목록 가져오기
    public List<joiningVO> getPendingJoinRequests(int partyIdx) {
        List<joiningVO> requestList = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            requestList = session.selectList("com.smhrd.db.Mapper.getPendingJoinRequests", partyIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestList;
    }

    // 가입 수락
    public int acceptJoinRequest(int joinIdx) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.update("com.smhrd.db.Mapper.acceptJoinRequest", joinIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 가입 거부
    public int rejectJoinRequest(int joinIdx) {
        int result = 0;
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            result = session.delete("com.smhrd.db.Mapper.rejectJoinRequest", joinIdx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}