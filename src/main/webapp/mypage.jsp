<%@page import="com.smhrd.model.userVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%
    // 세션에서 로그인된 사용자 정보 가져오기
    userVO loginUser = (userVO) session.getAttribute("loginUser");

    if (loginUser == null) {
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
<body>
    <div class="container">
        <h1>마이페이지</h1>
        <form action="updateUser" method="post">
            <label>비밀번호</label>
            <input type="password" name="pw" placeholder="새 비밀번호를 입력하세요" required>
            
            <label>이름</label>
            <input type="text" name="name" value="<%= loginUser.getName() %>" required>
            
            <label>지역</label>
            <input type="text" name="region" value="<%= loginUser.getRegion() %>" required>
            
            <button type="submit">수정완료</button>
        </form>

        <form action="deleteUser" method="post">
            <button type="submit" style="background-color: #dc3545;">계정 삭제</button>
        </form>
        
        <button type="button" onclick="history.back()">뒤로가기</button>
    </div>
</body>
</html>