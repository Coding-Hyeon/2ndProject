package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.postDAO;
import com.smhrd.model.postVO;
import com.smhrd.model.userVO;

@WebServlet("/createPost")
public class tb_post_createController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));
        String postNm = request.getParameter("postNm");
        String postContent = request.getParameter("postContent");
        String postFile = request.getParameter("postFile");

        postDAO dao = new postDAO();
        postVO post = new postVO(0, postNm, postContent, postFile, 0, 0, null, loginUser.getId(), partyIdx);
        int result = dao.createPost(post);

        if (result > 0) {
            response.sendRedirect("tb_party_partyPost?partyIdx=" + partyIdx);
        } else {
            response.sendRedirect("tb_party_createPost.jsp?partyIdx=" + partyIdx + "&error=createFail");
        }
    }
}
