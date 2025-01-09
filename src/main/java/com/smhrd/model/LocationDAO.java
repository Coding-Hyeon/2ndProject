package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

import java.util.HashMap;
import java.util.Map;

public class LocationDAO {
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    public Map<String, Object> getLocation(int postIdx) {
        SqlSession session = sqlSessionFactory.openSession();
        Map<String, Object> result = new HashMap<>();

        try {
            result = session.selectOne("com.smhrd.mapper.LocationMapper.getLocation", postIdx);
        } finally {
            session.close();
        }

        return result;
    }
}
