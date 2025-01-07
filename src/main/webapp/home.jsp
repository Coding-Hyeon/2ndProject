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
    <h3>공지사항</h3>
    <p>${party.announcement}</p>
    <c:if test="${isOwner}">
        <button onclick="location.href='partyUpdate.jsp?partyIdx=${party.partyIdx}'">정보 수정</button>
    </c:if>
</body>
</html>