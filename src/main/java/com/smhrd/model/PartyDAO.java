package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class PartyDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 모든 모임 가져오기 (모임 찾기)
    public List<PartyVO> selectAllParties(String userRegion) {
        SqlSession session = sqlSessionFactory.openSession();
        List<PartyVO> partyList = null;
        try {
            partyList = session.selectList("com.smhrd.db.Mapper.selectAllParties", userRegion);
        } finally {
            session.close();
        }
        return partyList;
    }

    // 내가 가입한 모임 가져오기 (나의 모임)
    public List<PartyVO> selectMyParties(String userId) {
        SqlSession session = sqlSessionFactory.openSession();
        List<PartyVO> myPartyList = null;
        try {
            myPartyList = session.selectList("com.smhrd.db.Mapper.selectMyParties", userId);
        } finally {
            session.close();
        }
        return myPartyList;
    }
    
    // 지역에 맞는 모임 목록 가져오기
    public List<PartyVO> selectPartiesByRegion(String userRegion) {
        SqlSession session = sqlSessionFactory.openSession();
        List<PartyVO> partyList = null;
        try {
            partyList = session.selectList("com.smhrd.db.Mapper.selectPartiesByRegion", userRegion);
        } finally {
            session.close();
        }
        return partyList;
    }
    
    // 모임 방 생성
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
    
    // 특정 모임 방 정보 가져오기
    public PartyVO selectPartyById(int partyIdx) {
        SqlSession session = sqlSessionFactory.openSession();
        PartyVO party = null;
        try {
            party = session.selectOne("com.smhrd.db.Mapper.selectPartyById", partyIdx);
        } finally {
            session.close();
        }
        return party;
    }

    // 모임 방에 가입된 회원 수 가져오기
    public int getMemberCount(int partyIdx) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = 0;
        try {
            count = session.selectOne("com.smhrd.db.Mapper.getMemberCount", partyIdx);
        } finally {
            session.close();
        }
        return count;
    }
    
    // 모임 방 수정
    public int updateParty(PartyVO party) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.update("com.smhrd.db.Mapper.updateParty", party);
        } finally {
            session.close();
        }
        return cnt;
    }

    // 모임 방 삭제
    public int deleteParty(int partyIdx) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
        int cnt = 0;
        try {
            cnt = session.delete("com.smhrd.db.Mapper.deleteParty", partyIdx);
        } finally {
            session.close();
        }
        return cnt;
    }
}
