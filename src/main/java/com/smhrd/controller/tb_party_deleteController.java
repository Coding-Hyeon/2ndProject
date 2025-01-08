package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.partyDAO;
import com.smhrd.model.partyVO;
import com.smhrd.model.userVO;

@WebServlet("/deleteParty")
public class tb_party_deleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 세션에서 로그인된 사용자 정보 가져오기
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));

        // DAO 호출
        partyDAO dao = new partyDAO();
        partyVO party = dao.getPartyById(partyIdx);

        // 방장 여부 확인
        if (party.getUserId().equals(loginUser.getId())) {
            int result = dao.deleteParty(partyIdx);
            if (result > 0) {
                response.sendRedirect("main.jsp?success=delete");
            } else {
                response.sendRedirect("partyDetails.jsp?partyIdx=" + partyIdx + "&error=deleteFail");
            }
        } else {
            response.sendRedirect("partyDetails.jsp?partyIdx=" + partyIdx + "&error=notAuthorized");
        }
    }
}
