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

@WebServlet("/editPostProcess")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class EditPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int postIdx = Integer.parseInt(request.getParameter("postIdx"));
        String postNm = request.getParameter("postTitle");
        String postContent = request.getParameter("postContent");

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
        PostVO post = new PostVO();
        post.setPostIdx(postIdx);
        post.setPostNm(postNm);
        post.setPostContent(postContent);
        post.setPostFile(fileName);
        post.setUserId(userId);

        // DAO 호출
        PostDAO dao = new PostDAO();
        int cnt = dao.updatePost(post);

        if (cnt > 0) {
            response.sendRedirect("partyRoom.jsp?partyIdx=" + post.getPartyIdx());
        } else {
            response.sendRedirect("editPost.jsp?postIdx=" + postIdx + "&error=fail");
        }
    }
}
