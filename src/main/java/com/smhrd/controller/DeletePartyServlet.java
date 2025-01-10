package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.PartyDAO;

@WebServlet("/deletePartyProcess")
public class DeletePartyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 요청에서 partyIdx 파라미터 확인
            String partyIdxParam = request.getParameter("partyIdx");
            if (partyIdxParam == null || partyIdxParam.isEmpty()) {
                throw new IllegalArgumentException("partyIdx 파라미터가 누락되었습니다.");
            }

            int partyIdx = Integer.parseInt(partyIdxParam);

            // DAO 호출
            PartyDAO dao = new PartyDAO();
            int result = dao.deleteParty(partyIdx);

            if (result > 0) {
                // 성공 시 메인 페이지로 이동
                response.sendRedirect("main.jsp");
            } else {
                // 실패 시 에러 메시지와 함께 원래 페이지로 이동
                request.setAttribute("errorMsg", "모임 삭제에 실패했습니다. 다시 시도해주세요.");
                request.getRequestDispatcher("partyRoom.jsp?partyIdx=" + partyIdx).forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            // 파라미터 오류 처리
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            // 기타 예외 처리
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "요청 처리 중 오류가 발생했습니다.");
        }
    }
}