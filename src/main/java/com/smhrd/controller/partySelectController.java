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
public class partySelectController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        if (loginUser != null) {
            String userRegion = loginUser.getUrg();
            partyDAO dao = new partyDAO();
            List<partyVO> partyList = dao.getPartiesByRegion(userRegion);

            request.setAttribute("partyList", partyList);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
