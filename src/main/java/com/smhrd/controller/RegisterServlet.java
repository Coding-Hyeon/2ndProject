package com.smhrd.controller;

import java.io.IOException;
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
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        String userGender = request.getParameter("userGender");
        String userAge = request.getParameter("userAge");
        String userRegion = request.getParameter("userRegion");

        UserVO user = new UserVO(userId, userPw, userName, userGender, userAge, userRegion);
        UserDAO dao = new UserDAO();

        int cnt = dao.insertUser(user);
        if (cnt > 0) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("register.jsp?error=fail");
        }
    }
}
