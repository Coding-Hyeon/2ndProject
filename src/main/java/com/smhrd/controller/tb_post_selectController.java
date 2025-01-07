package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.postDAO;
import com.smhrd.model.postVO;

@WebServlet("/partyPosts")
public class tb_post_selectController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));

        postDAO dao = new postDAO();
        List<postVO> postList = dao.getPostsByParty(partyIdx);

        request.setAttribute("postList", postList);
        request.setAttribute("partyIdx", partyIdx);

        request.getRequestDispatcher("partyPosts.jsp").forward(request, response);
    }
}
