<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <header>
        <button onclick="location.href='mypage.jsp'">마이페이지</button>
        <button onclick="location.href='logout'">로그아웃</button>
    </header>
    <h2>${party.partyNm}</h2>
    <img src="${party.partyFile}" alt="모임 이미지" width="300">
    <p>${party.partyInfo}</p>
    <p>가입자 수: ${party.memberCount}</p>
    <c:if test="${isMember}">
        <button onclick="location.href='latestPosts.jsp?partyIdx=${party.partyIdx}'">최신글</button>
        <button onclick="location.href='home.jsp?partyIdx=${party.partyIdx}'">홈</button>
    </c:if>
    <c:if test="${!isMember}">
        <button onclick="location.href='join.jsp?partyIdx=${party.partyIdx}'">가입하기</button>
    </c:if>
</body>
</html>