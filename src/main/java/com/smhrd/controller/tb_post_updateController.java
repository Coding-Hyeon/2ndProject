package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.postDAO;
import com.smhrd.model.postVO;

@WebServlet("/updatePost")
public class tb_post_updateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int postIdx = Integer.parseInt(request.getParameter("postIdx"));
        String postNm = request.getParameter("postNm");
        String postContent = request.getParameter("postContent");
        String postFile = request.getParameter("postFile");

        postDAO dao = new postDAO();
        postVO post = new postVO(postIdx, postNm, postContent, postFile, 0, 0, null, null, 0);
        int result = dao.updatePost(post);

        if (result > 0) {
            response.sendRedirect("tb_post_postDetails?postIdx=" + postIdx);
        } else {
            response.sendRedirect("partyUpdate.jsp?postIdx=" + postIdx + "&error=updateFail");
        }
    }
}
