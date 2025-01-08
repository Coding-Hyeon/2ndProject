package com.smhrd.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class partyDAO {
	private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// 방 생성
	public int createParty(partyVO party) {
		int result = 0;
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			result = session.insert("com.smhrd.db.Mapper.createParty", party);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 지역별 방 조회
	public List<partyVO> getPartiesByRegion(String region) {
		List<partyVO> partyList = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			partyList = session.selectList("com.smhrd.db.Mapper.getPartiesByRegion", region);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partyList;
	}
	
	// 특정 방 정보 조회
	public partyVO getPartyById(int partyIdx) {
	    partyVO party = null;
	    try (SqlSession session = sqlSessionFactory.openSession()) {
	        party = session.selectOne("com.smhrd.db.Mapper.getPartyById", partyIdx);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return party;
	}

	// 방 소개글 및 사진 업데이트
	public int updatePartyInfoAndFile(int partyIdx, String partyInfo, String partyFile) {
		int result = 0;
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("partyIdx", partyIdx);
			paramMap.put("partyInfo", partyInfo);
			paramMap.put("partyFile", partyFile);
			result = session.update("com.smhrd.db.Mapper.updatePartyInfoAndFile", paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 방 삭제
	public int deleteParty(int partyIdx) {
	    int result = 0;
	    try (SqlSession session = sqlSessionFactory.openSession(true)) {
	        result = session.delete("com.smhrd.db.Mapper.deleteParty", partyIdx);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
    // 사용자 가입 모임 가져오기
    public List<partyVO> getMyGroups(String userId) {
        List<partyVO> myGroups = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            myGroups = session.selectList("com.smhrd.db.Mapper.getMyGroups", userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myGroups;
    }
}
