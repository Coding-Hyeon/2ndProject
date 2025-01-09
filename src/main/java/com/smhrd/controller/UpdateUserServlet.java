package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.UserDAO;
import com.smhrd.model.UserVO;

@WebServlet("/updateUserProcess")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getUserId();
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        String userRegion = request.getParameter("userRegion");

        UserVO updatedUser = new UserVO(userId, userPw, userName, userRegion);
        updatedUser.setUserId(userId);
        updatedUser.setUserPw(userPw);
        updatedUser.setUserName(userName);
        updatedUser.setUserRegion(userRegion);

        UserDAO dao = new UserDAO();
        int cnt = dao.updateUser(updatedUser);

        if (cnt > 0) {
            session.setAttribute("user", updatedUser); // 업데이트된 사용자 정보 세션 갱신
            response.sendRedirect("viewUser");
        } else {
            response.sendRedirect("myPage.jsp?error=fail");
        }
    }
}
