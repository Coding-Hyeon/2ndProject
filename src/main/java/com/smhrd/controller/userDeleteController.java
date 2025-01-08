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

@WebServlet("/deleteUser")
public class userDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        if (loginUser != null) {
            userDAO dao = new userDAO();
            int result = dao.deleteUser(loginUser.getId());

            if (result > 0) {
                session.invalidate();
                response.sendRedirect("login.jsp?success=delete");
            } else {
                response.sendRedirect("mypage.jsp?error=deleteFail");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}