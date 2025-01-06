package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.smhrd.model.userDAO;
import com.smhrd.model.userVO;

@WebServlet("/login")
public class tb_user_loginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 사용자 입력값
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        // DAO 호출
        userDAO dao = new userDAO();
        userVO user = dao.login(id, pw);

        if (user != null) {
            // 로그인 성공 - 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user); // 사용자 정보를 세션에 저장
            response.sendRedirect("tb_user_loginSucess.jsp"); // 메인 페이지로 리다이렉트
        } else {
            // 로그인 실패 - 로그인 페이지로 돌아가기
            response.sendRedirect("tb_user_login.jsp?error=invalid");
        }
    }
}