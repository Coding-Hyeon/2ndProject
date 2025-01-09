package com.smhrd.controller;

import com.smhrd.model.LocationDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/locationPostProcessServlet") // URL 매핑
public class locationPostProcessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 데이터의 인코딩 설정
        request.setCharacterEncoding("UTF-8");

        // 폼 데이터 가져오기
        String title = request.getParameter("l_post_nm");
        String content = request.getParameter("l_post_content");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");

        try {
            // 데이터베이스에 저장
            LocationDAO locationDAO = new LocationDAO();
            boolean isInserted = locationDAO.insertLocationPost(
                title, content, Double.parseDouble(latitude), Double.parseDouble(longitude)
            );

            if (isInserted) {
                // 성공 시 모임방 페이지로 리다이렉트
                response.sendRedirect("partyRoom.jsp");
            } else {
                // 실패 시 에러 페이지 또는 경고 메시지 출력

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

