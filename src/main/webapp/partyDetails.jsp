<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>방 상세 정보</h1>
    <c:if test="${not empty party}">
        <p><strong>방 제목:</strong> ${party.partyNm}</p>
        <p><strong>방 소개:</strong> ${party.partyInfo}</p>
        <p><strong>방 지역:</strong> ${party.partyRegion}</p>
        <p><strong>방 생성자:</strong> ${party.userId}</p>
        <p><strong>생성 날짜:</strong> ${party.createdAt}</p>
    </c:if>
    <c:if test="${empty party}">
        <p>해당 방의 정보를 찾을 수 없습니다.</p>
    </c:if>
    
    <!-- 가입하기 버튼 -->
	<form action="<%= request.getContextPath() %>/createJoinRequest" method="get">
	    <input type="hidden" name="partyIdx" value="${party.partyIdx}">
	    <button type="submit" class="btn btn-primary">가입하기</button>
	</form>
	
	<div>
        <button onclick="location.href='main.jsp'">뒤로 가기</button>
    </div>
</body>
</html>