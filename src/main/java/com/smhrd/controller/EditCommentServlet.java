package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.CommentDAO;
import com.smhrd.model.CommentVO;
import com.smhrd.model.UserVO;

@WebServlet("/editCommentProcess")
public class EditCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int cmtIdx = Integer.parseInt(request.getParameter("cmtIdx"));
        String cmtContent = request.getParameter("commentContent");

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();

        // VO 객체 생성
        CommentVO comment = new CommentVO();
        comment.setCmtIdx(cmtIdx);
        comment.setCmtContent(cmtContent);
        comment.setUserId(userId);

        // DAO 호출
        CommentDAO dao = new CommentDAO();
        int cnt = dao.updateComment(comment);

        // 결과 처리
        if (cnt > 0) {
            response.sendRedirect("postDetails.jsp?postIdx=" + request.getParameter("postIdx"));
        } else {
            response.sendRedirect("editComment.jsp?cmtIdx=" + cmtIdx + "&error=fail");
        }
    }
}
