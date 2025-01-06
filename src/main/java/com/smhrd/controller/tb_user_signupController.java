package com.smhrd.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.userVO;
import com.smhrd.model.userDAO;

@WebServlet("/SignupController")
public class tb_user_signupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 한글 데이터 인코딩 설정
        request.setCharacterEncoding("UTF-8");

        // 파라미터 가져오기
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        char gender = request.getParameter("gender").charAt(0);
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String region = request.getParameter("region");
        LocalDateTime time = LocalDateTime.now();

        // VO 생성
        userVO user = new userVO(id, pw, name, gender, date, region, time);

        // DAO 호출
        userDAO dao = new userDAO();
        int result = dao.insertUser(user);

        // 결과 처리
        if (result > 0) {
            response.sendRedirect("tb_user_loginSuccess.jsp"); // 성공 페이지
        } else {
            response.sendRedirect("tb_user_login.jsp"); // 실패 페이지
        }
    }
}
