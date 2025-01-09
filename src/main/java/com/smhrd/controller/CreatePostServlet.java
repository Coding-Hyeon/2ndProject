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

import com.smhrd.model.PostDAO;
import com.smhrd.model.PostVO;
import com.smhrd.model.UserVO;

@WebServlet("/createPostProcess")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class CreatePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
        	
        	String partyIdxParam = request.getParameter("partyIdx");
            if (partyIdxParam == null || partyIdxParam.isEmpty()) {
                response.sendRedirect("createPost.jsp?error=invalidPartyIdx");
                return;
            }
            
        // 파라미터 값 가져오기
        String postNm = request.getParameter("postTitle");
        String postContent = request.getParameter("postContent");
        int partyIdx = Integer.parseInt(partyIdxParam);

        // 파일 업로드 처리
        Part filePart = request.getPart("postImage");
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

        // VO 객체 생성
        PostVO post = new PostVO(postNm, postContent, fileName, userId, partyIdx);

        // DAO 호출
        PostDAO dao = new PostDAO();
        int cnt = dao.insertPost(post);

        // 결과 처리
        if (cnt > 0) {
            response.sendRedirect("partyRoom.jsp?partyIdx=" + partyIdx);
        } else {
            response.sendRedirect("createPost.jsp?partyIdx=" + partyIdx + "&error=fail");
        }
        } catch (NumberFormatException e) {
            e.printStackTrace(); // 로그로 확인
            response.sendRedirect("createPost.jsp?error=invalidPartyIdx");
        } catch (IOException e) {
            e.printStackTrace(); // 로그로 확인
            response.sendRedirect("createPost.jsp?error=fileUploadFail");
        } catch (Exception e) {
            e.printStackTrace(); // 알 수 없는 오류 처리
            response.sendRedirect("createPost.jsp?error=unknown");
        }
    }
}