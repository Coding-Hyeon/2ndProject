package com.smhrd.controller;

import com.smhrd.model.LocationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/map") // "/map" URL로 매핑
public class MapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 요청에서 postIdx 가져오기
            int postIdx = Integer.parseInt(request.getParameter("postIdx"));

            // DAO를 통해 위치 정보 가져오기
            LocationDAO locationDAO = new LocationDAO();
            Map<String, Object> location = locationDAO.getLocation(postIdx);

            // 위치 정보가 있을 경우 request 속성으로 전달
            if (location != null) {
                request.setAttribute("latitude", location.get("latitude"));
                request.setAttribute("longitude", location.get("longitude"));
            } else {
                // 데이터가 없을 경우 기본 좌표를 설정
                request.setAttribute("latitude", 37.5665); // 서울 위도
                request.setAttribute("longitude", 126.9780); // 서울 경도
            }

            // JSP로 포워딩
            request.getRequestDispatcher("/jsp/kakaomap.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid postIdx");
        }
    }
}
