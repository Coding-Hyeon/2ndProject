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
public class tb_party_createController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 세션에서 로그인 사용자 가져오기
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        if (loginUser != null) {
            String partyNm = request.getParameter("party_nm");
            String partyInfo = request.getParameter("party_info");
            String partyRegion = request.getParameter("party_region");
            String partyFile = request.getParameter("party_file");

            // partyVO 생성
            partyVO party = new partyVO(0, partyNm, partyInfo, partyRegion, partyFile, null, loginUser.getId());

            // DAO 호출
            partyDAO dao = new partyDAO();
            int result = dao.createParty(party);

            if (result > 0) {
                response.sendRedirect("tb_party_main.jsp?success=create");
            } else {
                response.sendRedirect("tb_party_createParty.jsp?error=createFail");
            }
        } else {
            response.sendRedirect("tb_user_login.jsp");
        }
    }
}