package com.smhrd.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.smhrd.model.UserDAO;
import com.smhrd.model.UserVO;

@WebServlet("/registerProcess")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 폼 데이터 수집
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        String userGender = request.getParameter("userGender");
        String userAge = request.getParameter("userAge"); // yyyy-MM-dd 형식
        String userRegion = request.getParameter("userRegion");

        // userAge를 Date로 변환
        Date userAgeDate = Date.valueOf(userAge);

        // UserVO 객체 생성
        UserVO user = new UserVO(userId, userPw, userName, userGender, userAgeDate, userRegion);

        // DAO 호출
        UserDAO dao = new UserDAO();
        int cnt = dao.insertUser(user);

        // 결과 처리
        if (cnt > 0) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("register.jsp?error=fail");
        }
    }
}