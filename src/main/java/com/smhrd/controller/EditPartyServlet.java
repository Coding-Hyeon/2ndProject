package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.smhrd.model.PartyDAO;
import com.smhrd.model.PartyVO;
import com.smhrd.model.UserVO;

@WebServlet("/editPartyProcess")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class EditPartyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));
        String partyNm = request.getParameter("partyTitle");
        String partyInfo = request.getParameter("partyDescription");
        String partyRegion = request.getParameter("partyRegion");

        // 파일 업로드 처리
        Part filePart = request.getPart("partyImage");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = filePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("/") + "uploads/";
            filePart.write(uploadPath + fileName);
        }

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();

        PartyVO party = new PartyVO(partyIdx, partyNm, partyInfo, partyRegion, fileName, userId);
        PartyDAO dao = new PartyDAO();
        int cnt = dao.updateParty(party);

        if (cnt > 0) {
            response.sendRedirect("partyRoom.jsp?partyIdx=" + partyIdx);
        } else {
            response.sendRedirect("editParty.jsp?partyIdx=" + partyIdx + "&error=fail");
        }
    }
}
