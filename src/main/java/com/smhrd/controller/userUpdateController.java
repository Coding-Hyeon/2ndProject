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

@WebServlet("/updateUser")
public class userUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        if (loginUser != null) {
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String region = request.getParameter("region");

            loginUser.setPw(pw);
            loginUser.setName(name);
            loginUser.setUrg(region);

            userDAO dao = new userDAO();
            int result = dao.updateUser(loginUser);

            if (result > 0) {
                session.setAttribute("loginUser", loginUser);
                response.sendRedirect("mypage.jsp?success=update");
            } else {
                response.sendRedirect("mypage.jsp?error=updateFail");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}