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

@WebServlet("/viewUser")
public class ViewUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();

        UserDAO dao = new UserDAO();
        UserVO userInfo = dao.selectUserById(userId);

        if (userInfo != null) {
            request.setAttribute("userInfo", userInfo);
            request.getRequestDispatcher("myPage.jsp").forward(request, response);
        } else {
            response.sendRedirect("main.jsp");
        }
    }
}
