package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.partyDAO;
import com.smhrd.model.partyVO;
import com.smhrd.model.userVO;

@WebServlet("/main")
public class tb_party_selectController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        if (loginUser != null) {
            String userRegion = loginUser.getRegion();

            // DAO 호출
            partyDAO dao = new partyDAO();
            List<partyVO> partyList = dao.getPartiesByRegion(userRegion);

            // 요청 속성에 파티 리스트 저장
            request.setAttribute("partyList", partyList);

            // main.jsp로 이동
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}