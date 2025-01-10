<%@page import="com.smhrd.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    UserVO user = (UserVO) session.getAttribute("user");
    if (user == null) {
        // 로그인되지 않은 경우 로그인 페이지로 이동
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- Header -->
    <header>
        <h1>메인 페이지</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <section>
            <h2>무엇을 하시겠습니까?</h2>
            <div>
                <button onclick="location.href='<%= request.getContextPath() %>/findPartyProcess'">모임 찾기</button>
            </div>
            <div>
                <button onclick="location.href='myParties'">나의 모임</button>
            </div>
        </section>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>
</body>
</html>