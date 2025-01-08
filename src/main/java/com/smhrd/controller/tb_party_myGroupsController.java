// MyGroupsController.java
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

@WebServlet("/myGroups")
public class tb_party_myGroupsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        if (loginUser != null) {
            String userId = loginUser.getId();

            partyDAO dao = new partyDAO();
            List<partyVO> myGroups = dao.getMyGroups(userId);

            if (myGroups != null) {
                request.setAttribute("myGroups", myGroups);
                request.getRequestDispatcher("myGroups.jsp").forward(request, response);
            } else {
                response.sendRedirect("main.jsp?error=noGroups");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
