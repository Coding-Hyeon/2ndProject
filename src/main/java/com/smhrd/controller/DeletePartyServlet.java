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

@WebServlet("/deletePartyProcess")
public class DeletePartyServlet extends HttpServlet {
    // GET 요청으로 모임방 삭제 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 요청에서 모임방 ID 가져오기
            int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));

            // DB에서 모임방 삭제
            PartyDAO dao = new PartyDAO();
            int result = dao.deleteParty(partyIdx);

            if (result > 0) {
                // 성공 시 메인 페이지로 이동
                response.sendRedirect("main.jsp");
            } else {
                // 실패 시 에러 메시지 표시
                request.setAttribute("errorMsg", "삭제에 실패했습니다. 다시 시도해주세요.");
                request.getRequestDispatcher("partyRoom.jsp?partyIdx=" + partyIdx).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "요청 처리 중 오류가 발생했습니다.");
        }
    }
}