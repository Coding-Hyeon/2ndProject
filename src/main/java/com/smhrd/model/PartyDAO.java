package com.smhrd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            if (myPartyList == null || myPartyList.isEmpty()) {
                System.out.println("No parties found for user: " + userId);
            } else {
                for (PartyVO party : myPartyList) {
                    if (party == null) {
                        System.out.println("Null party object found!");
                    } else {
                        System.out.println("Party name: " + party.getPartyNm());  // Log party name
                    }
                }
            }
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
            // 모임 삽입
            cnt = session.insert("com.smhrd.db.Mapper.insertParty", party);
            // 생성된 partyIdx 값 확인
            System.out.println("Generated partyIdx: " + party.getPartyIdx()); // 자동 생성된 partyIdx 출력
            return party.getPartyIdx(); // 자동 생성된 partyIdx 반환
        } finally {
            session.close();
        }
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
    
 // 모임방 정보 수정
    public int updateParty(PartyVO party) {
        String sql = "UPDATE tb_party SET party_nm = ?, party_info = ?, party_region = ?, party_file = ? WHERE party_idx = ?";
        try (Connection conn = SqlSessionManager.getSqlSession().openSession().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, party.getPartyNm());
            pstmt.setString(2, party.getPartyInfo());
            pstmt.setString(3, party.getPartyRegion());
            pstmt.setString(4, party.getPartyFile());
            pstmt.setInt(5, party.getPartyIdx());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    // 모임방 삭제
    public int deleteParty(int partyIdx) throws SQLException {
        String sql = "DELETE FROM tb_party WHERE party_idx = ?";
        try (Connection conn = SqlSessionManager.getSqlSession().openSession().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, partyIdx);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("모임 삭제 중 오류 발생: " + e.getMessage());
            throw e; // 예외를 호출한 서블릿으로 전달
        }
    }
	public boolean updateParty(int partyIdx, String partyTitle, String partyDescription, String partyRegion,
			String fileName, String partyNotice) {

		return false;
	}


	//기존 파일명을 가져오는 메서드
	public String getExistingFileName(int partyIdx) {
	    String sql = "SELECT party_file FROM tb_party WHERE party_idx = ?";
	    try (Connection conn = SqlSessionManager.getSqlSession().openSession().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	
	        pstmt.setInt(1, partyIdx);
	        ResultSet rs = pstmt.executeQuery();
	
	        if (rs.next()) {
	            return rs.getString("party_file"); // 기존 파일명 반환
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; // 파일명이 없을 경우 null 반환
	}
	
	public PartyVO selectPartyByIdx(int partyIdx) {
	    SqlSession session = sqlSessionFactory.openSession();
	    PartyVO party = null;
	    try {
	        party = session.selectOne("com.smhrd.db.Mapper.selectPartyByIdx", partyIdx);
	    } finally {
	        session.close();
	    }
	    return party;
	}
	
	public int insertJoinRequest(String userId, int partyIdx, String joinIntro, char agreeYn) {
	    SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit
	    int result = 0;
	    try {
	        JoinRequestVO joinRequest = new JoinRequestVO(userId, partyIdx, joinIntro, agreeYn);
	        result = session.insert("com.smhrd.db.Mapper.insertJoinRequest", joinRequest);
	    } finally {
	        session.close();
	    }
	    return result;
	}
}
