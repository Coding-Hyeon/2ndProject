package com.smhrd.model;

import java.util.Map;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class LocationDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 위치 기반 글 저장 메서드
    public boolean insertLocationPost(String l_post_nm, String l_post_content, double latitude, double longitude) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            LocationVO location = new LocationVO();
            location.setL_post_nm(l_post_nm);
            location.setL_post_content(l_post_content);
            location.setLatitude(latitude);
            location.setLongitude(longitude);

            int result = session.insert("com.smhrd.db.Mapper.insertLocationPost", location);
            session.commit();
            return result > 0; // 삽입 성공 여부 반환
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        } finally {
            session.close();
        }
    }

// 특정 위치 데이터 조회 메서드
public Map<String, Object> getLocation(int postIdx) {
    SqlSession session = sqlSessionFactory.openSession();
    Map<String, Object> result = new HashMap<>();

    try {
        // MyBatis Mapper에서 SQL 실행
        result = session.selectOne("com.smhrd.mapper.LocationMapper.getLocation", postIdx);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return result;
}
}
