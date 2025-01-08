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
        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));

        // DAO 호출
        PartyDAO dao = new PartyDAO();
        PartyVO party = dao.selectPartyById(partyIdx);
        int memberCount = dao.getMemberCount(partyIdx);

        // 모임 방 정보와 회원 수 설정
        party.setMemberCount(memberCount);

        // request에 데이터 저장
        request.setAttribute("party", party);

        // JSP로 포워딩
        request.getRequestDispatcher("partyRoom.jsp").forward(request, response);
    }
}
