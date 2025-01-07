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

        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        userDAO dao = new userDAO();
        userVO user = dao.login(id, pw);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            response.sendRedirect("tb_party_main");
        } else {
            response.sendRedirect("tb_user_login.jsp?error=invalid");
        }
    }
}