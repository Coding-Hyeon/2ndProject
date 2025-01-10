package com.smhrd.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
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


@WebServlet("/createPartyProcess")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class CreatePartyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            // 파라미터 값 가져오기
            String partyNm = request.getParameter("partyTitle");
            String partyInfo = request.getParameter("partyDescription");
            String partyRegion = request.getParameter("partyRegion");

            // 파일 업로드 처리
            Part filePart = request.getPart("partyImage");
            String fileName = null;
            if (filePart != null && filePart.getSize() > 0) {
                fileName = filePart.getSubmittedFileName();
                String uploadPath = getServletContext().getRealPath("/") + "uploads/";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                filePart.write(uploadPath + fileName);
            }

            // 세션에서 사용자 정보 가져오기
            HttpSession session = request.getSession();
            UserVO user = (UserVO) session.getAttribute("user");

            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            String userId = user.getUserId();

            // VO 객체 생성
            PartyVO party = new PartyVO(partyNm, partyInfo, partyRegion, fileName, userId);

            // DAO 호출하여 모임 생성
            PartyDAO dao = new PartyDAO();
            int partyIdx = dao.insertParty(party);  // 생성된 모임의 partyIdx 값
            System.out.println("Generated partyIdx: " + partyIdx); // partyIdx 확인 로그
            
            if (partyIdx > 0) {
                // 방 생성 후, 자동으로 해당 모임에 가입 처리 (방장은 'y'로 가입)
                dao.insertJoinRequest(userId, partyIdx, "방장으로 자동 가입됨", 'y');  // 자동 가입, 'y'로 설정

                response.sendRedirect("partyRoom.jsp?partyIdx=" + partyIdx);
            } else {
                response.sendRedirect("createParty.jsp?error=fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "오류가 발생했습니다: " + e.getMessage());
            request.getRequestDispatcher("createParty.jsp").forward(request, response);
        }
    }
}