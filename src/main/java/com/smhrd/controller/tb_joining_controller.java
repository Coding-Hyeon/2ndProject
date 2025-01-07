package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.joiningDAO;
import com.smhrd.model.joiningVO;
import com.smhrd.model.userVO;

@WebServlet("/applyJoin")
public class tb_joining_controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");
        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));
        String joinIntro = request.getParameter("joinIntro");

        if (loginUser != null) {
            joiningDAO dao = new joiningDAO();
            joiningVO joining = new joiningVO(0, partyIdx, loginUser.getId(), joinIntro, 'N', null);
            int result = dao.applyJoining(joining);

            if (result > 0) {
                response.sendRedirect("tb_joning_partyDetails?partyIdx=" + partyIdx + "&success=apply");
            } else {
                response.sendRedirect("tb_joning_partyDetails?partyIdx=" + partyIdx + "&error=applyFail");
            }
        } else {
            response.sendRedirect("tb_user_login.jsp");
        }
    }
}
