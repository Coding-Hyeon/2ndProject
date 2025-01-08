package com.smhrd.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.userDAO;
import com.smhrd.model.userVO;

@WebServlet("/SignupController")
public class signupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        char gender = request.getParameter("gender").charAt(0);
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String region = request.getParameter("region");
        LocalDateTime time = LocalDateTime.now();

        userVO user = new userVO(id, pw, name, gender, date, region, time);
        userDAO dao = new userDAO();
        int result = dao.insertUser(user);

        if (result > 0) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("signup.jsp?error=signupFail");
        }
    }
}
