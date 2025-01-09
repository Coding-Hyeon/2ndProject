package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.PartyDAO;
import com.smhrd.model.PartyVO;

@WebServlet("/partyRoomProcess")
public class PartyRoomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 모임 방 ID 가져오기
    	
    	String partyIdxStr = request.getParameter("partyIdx");
    	
    	if (partyIdxStr == null || partyIdxStr.isEmpty()) {
    		request.setAttribute("errorMsg", "모임 방 ID가 제공되지 않았습니다.");
    		request.getRequestDispatcher("errorPage.jsp").forward(request, response);
    		return;
    	}
    	
    	int partyIdx = 0;
    	try {
    		partyIdx = Integer.parseInt(partyIdxStr);
    	} catch (NumberFormatException e) {
    		request.setAttribute("errorMsg", "잘못된 모임 방 ID입니다.");
    		request.getRequestDispatcher("errorPage.jsp").forward(request, response);
    		return;
    	}
    	
    	PartyDAO dao = new PartyDAO();
    	PartyVO party = dao.selectPartyById(partyIdx);
    	if (party == null) {
    		request.setAttribute("errorMsg", "해당 모임 방 정보를 찾을 수 없습니다.");
    		request.getRequestDispatcher("errorPage.jsp").forward(request, response);
    		return;
    	}
    	
    	int memberCount = dao.getMemberCount(partyIdx);
    	party.setMemberCount(memberCount);
    
    	request.setAttribute("party", party);
    	request.getRequestDispatcher("partyRoom.jsp").forward(request, response);
    }
}