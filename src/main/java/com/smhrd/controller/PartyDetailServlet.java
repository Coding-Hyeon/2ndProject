package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.PartyDAO;
import com.smhrd.model.PartyVO;

@WebServlet("/partyDetailProcess")
public class PartyDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));
        
        PartyDAO dao = new PartyDAO();
        PartyVO party = dao.selectPartyByIdx(partyIdx);
        
        if (party != null) {
            request.setAttribute("party", party);
        } else {
            request.setAttribute("errorMsg", "해당 방의 정보를 찾을 수 없습니다.");
        }
        
        request.getRequestDispatcher("partyDetails.jsp").forward(request, response);
    }
}
