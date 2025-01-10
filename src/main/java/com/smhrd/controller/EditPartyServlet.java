package com.smhrd.controller;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.smhrd.model.PartyDAO;
import com.smhrd.model.PartyVO;

@WebServlet("/editPartyProcess")
@MultipartConfig
public class EditPartyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 요청 데이터 처리
            String partyIdxStr = request.getParameter("partyIdx");
            String partyNm = request.getParameter("partyTitle");
            String partyInfo = request.getParameter("partyDescription");
            String partyRegion = request.getParameter("partyRegion");
            Part filePart = request.getPart("partyFile");

            String fileName = null;
            if (filePart != null && filePart.getSize() > 0) {
                fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                filePart.write("C:/upload/" + fileName);
            } else {
                fileName = new PartyDAO().getExistingFileName(Integer.parseInt(partyIdxStr));
            }

            int partyIdx = Integer.parseInt(partyIdxStr);
            PartyVO party = new PartyVO(partyIdx, partyNm, partyInfo, partyRegion, fileName, null);

            // DB 업데이트
            PartyDAO dao = new PartyDAO();
            int result = dao.updateParty(party);

            // 수정 결과 JSP 전달
            if (result > 0) {
                request.setAttribute("isEditSuccess", true);
            } else {
                request.setAttribute("isEditSuccess", false);
                request.setAttribute("errorMsg", "수정에 실패했습니다. 다시 시도해주세요.");
            }
            request.getRequestDispatcher("editParty.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "요청 처리 중 오류가 발생했습니다.");
        }
    }
}