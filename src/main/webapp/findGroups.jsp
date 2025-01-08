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
    <h2>모임 찾기</h2>
    <button onclick="location.href='partyCreate.jsp'">모임 생성</button>
    <c:forEach var="party" items="${partyList}">
        <div>
            <h3>${party.partyNm}</h3>
            <p>방장: ${party.userId}</p>
            <p>가입자 수: ${party.memberCount}</p>
            <img src="${party.partyFile}" alt="모임 이미지" width="100"><br>
            <button onclick="location.href='partyDetails.jsp?partyIdx=${party.partyIdx}'">모임 보기</button>
        </div>
    </c:forEach>
</body>
</html>