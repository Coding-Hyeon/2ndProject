package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createJoinRequest")
public class CreateJoinRequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // partyIdx 파라미터 받아오기
        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));
        
        // partyIdx를 JSP로 전달
        request.setAttribute("partyIdx", partyIdx);
        
        // 소개글 입력 페이지로 포워딩
        request.getRequestDispatcher("joinRequestForm.jsp").forward(request, response);
    }
}