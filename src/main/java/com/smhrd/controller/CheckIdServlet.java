package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.UserDAO;

@WebServlet("/checkId")
public class CheckIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");

        UserDAO dao = new UserDAO();
        boolean exists = dao.checkDuplicateId(userId);

        response.setContentType("text/plain; charset=UTF-8");
        if (exists) {
            response.getWriter().write("이미 존재하는 아이디입니다.");
        } else {
            response.getWriter().write("사용 가능한 아이디입니다.");
        }
    }
}
