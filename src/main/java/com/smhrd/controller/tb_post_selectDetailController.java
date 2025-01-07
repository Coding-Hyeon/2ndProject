package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.commentDAO;
import com.smhrd.model.commentVO;
import com.smhrd.model.postDAO;
import com.smhrd.model.postVO;

@WebServlet("/postDetails")
public class tb_post_selectDetailController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int postIdx = Integer.parseInt(request.getParameter("postIdx"));

        postDAO postDao = new postDAO();
        commentDAO commentDao = new commentDAO();

        postVO post = postDao.getPostById(postIdx);
        List<commentVO> commentList = commentDao.getCommentsByPost(postIdx);

        request.setAttribute("post", post);
        request.setAttribute("commentList", commentList);

        request.getRequestDispatcher("tb_post_postDetails.jsp").forward(request, response);
    }
}
