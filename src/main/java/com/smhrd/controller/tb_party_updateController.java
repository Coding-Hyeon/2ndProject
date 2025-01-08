package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.partyDAO;

@WebServlet("/updatePartyInfo")
public class tb_party_updateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int partyIdx = Integer.parseInt(request.getParameter("partyIdx"));
        String partyInfo = request.getParameter("partyInfo");
        String partyFile = request.getParameter("partyFile");

        partyDAO dao = new partyDAO();
        int result = dao.updatePartyInfoAndFile(partyIdx, partyInfo, partyFile);

        if (result > 0) {
            response.sendRedirect("partyDetails?partyIdx=" + partyIdx + "&success=update");
        } else {
            response.sendRedirect("partyDetails?partyIdx=" + partyIdx + "&error=updateFail");
        }
    }
}
