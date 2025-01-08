package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.UserDAO;
import com.smhrd.model.UserVO;

@WebServlet("/loginProcess")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        UserDAO dao = new UserDAO();
        UserVO user = dao.loginUser(userId, userPw);

        if (user != null) {
            // 로그인 성공: 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("main.jsp");
        } else {
            // 로그인 실패: 로그인 페이지로 리다이렉트
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
