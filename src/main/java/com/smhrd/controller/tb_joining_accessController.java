package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.joiningDAO;

@WebServlet("/manageJoinRequests")
public class tb_joining_accessController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int joinIdx = Integer.parseInt(request.getParameter("joinIdx"));
        String action = request.getParameter("action");

        joiningDAO dao = new joiningDAO();

        if ("accept".equals(action)) {
            dao.acceptJoinRequest(joinIdx);
        } else if ("reject".equals(action)) {
            dao.rejectJoinRequest(joinIdx);
        }

        response.sendRedirect("joinRequests?success=" + action);
    }
}
