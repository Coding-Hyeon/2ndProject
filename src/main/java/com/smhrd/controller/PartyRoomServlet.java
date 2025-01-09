package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.PartyDAO;
import com.smhrd.model.PartyVO;
import com.smhrd.model.PostDAO;
import com.smhrd.model.PostVO;

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
            e.printStackTrace();
            request.setAttribute("errorMsg", "잘못된 모임 방 ID입니다.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }

        // 모임 방 정보 가져오기
        PartyDAO dao = new PartyDAO();
        PartyVO party = dao.selectPartyById(partyIdx);
        if (party == null) {
            request.setAttribute("errorMsg", "해당 모임 방 정보를 찾을 수 없습니다.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }

        // 모임 방 가입자 수 가져오기
        int memberCount = dao.getMemberCount(partyIdx);
        party.setMemberCount(memberCount);

        // 최신 글 정보 가져오기
        PostDAO postDAO = new PostDAO();
        List<PostVO> latestPosts = postDAO.selectLatestPostsByParty(partyIdx);

        // JSP에 전달할 데이터 설정
        request.setAttribute("party", party);
        request.setAttribute("latestPosts", latestPosts);

        // JSP로 포워딩
        request.getRequestDispatcher("partyRoom.jsp").forward(request, response);
    }
}