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

@WebServlet("/submitJoinRequest")
public class SubmitJoinRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String joinIntro = request.getParameter("joinIntro");
        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));
        
        // 세션에서 로그인한 사용자 정보 가져오기
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        String userId = user.getUserId();
        
        // DAO 호출하여 가입 신청 저장
        PartyDAO dao = new PartyDAO();
        int result = dao.insertJoinRequest(userId, partyIdx, joinIntro);
        
        if (result > 0) {
            // 가입 신청 성공 후 리다이렉트
            response.sendRedirect("main.jsp?partyIdx=" + partyIdx);
        } else {
            // 실패 시 에러 메시지
            response.sendRedirect("joinRequestForm.jsp?error=fail");
        }
    }
}
