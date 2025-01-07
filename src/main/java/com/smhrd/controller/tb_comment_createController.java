package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.commentDAO;
import com.smhrd.model.commentVO;
import com.smhrd.model.userVO;

@WebServlet("/createComment")
public class tb_comment_createController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        int postIdx = Integer.parseInt(request.getParameter("postIdx"));
        String content = request.getParameter("content");

        commentDAO dao = new commentDAO();
        commentVO comment = new commentVO(0, postIdx, content, null, loginUser.getId());
        int result = dao.createComment(comment);

        if (result > 0) {
            response.sendRedirect("tb_post_postDetails?postIdx=" + postIdx);
        } else {
            response.sendRedirect("tb_post_postDetails?postIdx=" + postIdx + "&error=commentFail");
        }
    }
}
