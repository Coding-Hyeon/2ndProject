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
@MultipartConfig // multipart/form-data 요청 처리
public class EditPartyProcess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 요청에서 일반 폼 데이터 가져오기
            String partyIdxStr = request.getParameter("partyIdx");
            String partyNm = request.getParameter("partyTitle");
            String partyInfo = request.getParameter("partyDescription");
            String partyRegion = request.getParameter("partyRegion");

            // 파일 업로드 처리
            Part filePart = request.getPart("partyFile"); // name="partyFile"
            String fileName = null; // 파일명 초기화

            if (filePart != null && filePart.getSize() > 0) {
                // 파일이 선택되었을 경우 처리
                fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // 파일명 가져오기
                filePart.write("C:/upload/" + fileName); // 파일 저장 (저장 경로 변경 필요)
            } else {
                // 파일이 선택되지 않았을 경우
                System.out.println("파일이 선택되지 않았습니다.");
            }
            

            // 파라미터 유효성 검증
            if (partyIdxStr == null || partyNm == null || partyInfo == null || partyRegion == null) {
                throw new IllegalArgumentException("필수 파라미터가 누락되었습니다.");
            }

            int partyIdx = Integer.parseInt(partyIdxStr);

            // DB에 모임방 정보를 업데이트
            PartyVO party = new PartyVO(partyIdx, partyNm, partyInfo, partyRegion, fileName, null);
            PartyDAO dao = new PartyDAO();
            int result = dao.updateParty(party);

            if (result > 0) {
                // 성공 시 모임방 페이지로 리다이렉트
                response.sendRedirect("partyRoom.jsp?partyIdx=" + partyIdx);
            } else {
                // 실패 시 데이터를 다시 JSP로 전달
                request.setAttribute("errorMsg", "수정에 실패했습니다. 다시 시도해주세요.");
                request.setAttribute("party", party); // 수정 실패 시 기존 데이터 전달
                request.getRequestDispatcher("editParty.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
            request.getRequestDispatcher("editParty.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "요청 처리 중 오류가 발생했습니다.");
        }
        System.out.println("partyIdx: " + request.getParameter("partyIdx"));
        System.out.println("partyTitle: " + request.getParameter("partyTitle"));
        System.out.println("partyDescription: " + request.getParameter("partyDescription"));
        System.out.println("partyRegion: " + request.getParameter("partyRegion"));
        
    }
}