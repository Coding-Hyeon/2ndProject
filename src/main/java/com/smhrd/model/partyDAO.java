package com.smhrd.model;

import java.util.List;

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
}
