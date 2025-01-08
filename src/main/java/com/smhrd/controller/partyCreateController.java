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

@WebServlet("/createParty")
public class partyCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String partyNm = request.getParameter("party_nm");
        String partyInfo = request.getParameter("party_info");
        String partyRegion = request.getParameter("party_region");
        String partyFile = request.getParameter("party_file");
        
        HttpSession session = request.getSession();
        
        String userId = (String)session.getAttribute("user_id");

        // 로그 출력
        System.out.println("partyNm: " + partyNm);
        System.out.println("partyInfo: " + partyInfo);
        System.out.println("partyRegion: " + partyRegion);
        System.out.println("partyFile: " + partyFile);

        // DAO 호출
        partyVO party = new partyVO(0, partyNm, partyInfo, partyRegion, partyFile, null, userId);
        partyDAO dao = new partyDAO();
        int result = dao.createParty(party);

        if (result > 0) {
            System.out.println("모임방 생성 성공!");
            response.sendRedirect("partyDetails.jsp?partyIdx=" + result);
        } else {
            System.out.println("모임방 생성 실패!");
            response.sendRedirect("createParty.jsp?error=createFail");
        }
    }
}