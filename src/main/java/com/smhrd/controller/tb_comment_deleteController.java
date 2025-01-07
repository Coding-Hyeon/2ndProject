package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.commentDAO;

@WebServlet("/deleteComment")
public class tb_comment_deleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int commentIdx = Integer.parseInt(request.getParameter("commentIdx"));

        commentDAO dao = new commentDAO();
        int result = dao.deleteComment(commentIdx);

        if (result > 0) {
            response.sendRedirect("postDetails?success=deleteComment");
        } else {
            response.sendRedirect("postDetails?error=deleteCommentFail");
        }
    }
}
