package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.PostDAO;
import com.smhrd.model.UserVO;

@WebServlet("/deletePostProcess")
public class DeletePostServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postIdx = Integer.parseInt(request.getParameter("postIdx"));

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();

        PostDAO dao = new PostDAO();
        int cnt = dao.deletePost(postIdx);

        if (cnt > 0) {
            response.sendRedirect("partyRoom.jsp");
        } else {
            response.sendRedirect("editPost.jsp?postIdx=" + postIdx + "&error=fail");
        }
    }
}
