package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.smhrd.model.userDAO;
import com.smhrd.model.userVO;

@WebServlet("/updateUser")
public class tb_user_updateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        userVO loginUser = (userVO) session.getAttribute("loginUser");

        if (loginUser != null) {
            String name = request.getParameter("name");
            String pw = request.getParameter("pw");
            String region = request.getParameter("region");

            userDAO dao = new userDAO();

            // 이름 중복 검사
            if (dao.isNameDuplicated(name) && !name.equals(loginUser.getName())) {
                response.sendRedirect("tb_user_mypage.jsp?error=duplicateName");
                
                return;
            }

            // 정보 업데이트
            loginUser.setName(name);
            loginUser.setPw(pw);
            loginUser.setRegion(region);

            int result = dao.updateUser(loginUser);
            if (result > 0) {
                session.setAttribute("loginUser", loginUser); // 세션 업데이트
                response.sendRedirect("tb_user_mypage.jsp?success=update");
            } else {
                response.sendRedirect("tb_user_mypage.jsp?error=updateFail");
            }
        } else {
            response.sendRedirect("tb_user_login.jsp");
        }
    }
}
