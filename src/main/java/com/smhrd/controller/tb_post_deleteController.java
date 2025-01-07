package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.postDAO;

@WebServlet("/deletePost")
public class tb_post_deleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int postIdx = Integer.parseInt(request.getParameter("postIdx"));

        postDAO dao = new postDAO();
        int result = dao.deletePost(postIdx);

        if (result > 0) {
            response.sendRedirect("tb_post_partyPost?success=delete");
        } else {
            response.sendRedirect("tb_post_postDetails?postIdx=" + postIdx + "&error=deleteFail");
        }
    }
}