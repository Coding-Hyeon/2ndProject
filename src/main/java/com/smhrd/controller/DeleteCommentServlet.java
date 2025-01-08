package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.CommentDAO;
import com.smhrd.model.UserVO;

@WebServlet("/deleteCommentProcess")
public class DeleteCommentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cmtIdx = Integer.parseInt(request.getParameter("cmtIdx"));

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();

        CommentDAO dao = new CommentDAO();
        int cnt = dao.deleteComment(cmtIdx);

        // 결과 처리
        if (cnt > 0) {
            response.sendRedirect("postDetails.jsp?postIdx=" + request.getParameter("postIdx"));
        } else {
            response.sendRedirect("editComment.jsp?cmtIdx=" + cmtIdx + "&error=fail");
        }
    }
}
