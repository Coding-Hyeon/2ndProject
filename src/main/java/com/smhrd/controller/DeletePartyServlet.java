package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.PartyDAO;
import com.smhrd.model.UserVO;

@WebServlet("/deletePartyProcess")
public class DeletePartyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();

        PartyDAO dao = new PartyDAO();
        int cnt = dao.deleteParty(partyIdx);

        if (cnt > 0) {
            response.sendRedirect("main.jsp");
        } else {
            response.sendRedirect("editParty.jsp?partyIdx=" + partyIdx + "&error=fail");
        }
    }
}