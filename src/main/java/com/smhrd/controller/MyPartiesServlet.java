package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.PartyDAO;
import com.smhrd.model.PartyVO;
import com.smhrd.model.UserVO;

@WebServlet("/myParties")
public class MyPartiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 로그인한 사용자 정보 가져오기
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        // 로그인하지 않은 사용자 처리
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();

        // PartyDAO에서 사용자가 가입한 승인된 모임 리스트 가져오기
        PartyDAO partyDAO = new PartyDAO();
        List<PartyVO> myParties = partyDAO.selectMyParties(userId);
        
     // 데이터가 정상적으로 조회되었는지 로그 확인
        System.out.println("Number of parties: " + (myParties != null ? myParties.size() : "null"));

        // `myParties`가 null이거나 비어있으면 에러 메시지 설정
        if (myParties == null || myParties.isEmpty()) {
            request.setAttribute("errorMsg", "가입된 승인된 모임이 없습니다.");
        } else {
            request.setAttribute("myParties", myParties);
        }

        // `myParty.jsp`로 포워딩
        request.getRequestDispatcher("myParty.jsp").forward(request, response);
    }
}
