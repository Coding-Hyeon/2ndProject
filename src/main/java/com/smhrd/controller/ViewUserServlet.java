package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.smhrd.model.UserVO;

@WebServlet("/viewUser")
public class ViewUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            // 로그인 정보가 없으면 로그인 페이지로 이동
            response.sendRedirect("login.jsp");
        } else {
            // 로그인된 상태라면 마이페이지로 이동
            request.setAttribute("userInfo", user);
            request.getRequestDispatcher("myPage.jsp").forward(request, response);
        }
    }
}
