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
    <!-- Header -->
    <header>
    <h1>내 지역의 모임 목록</h1>
	<c:if test="${not empty partyList}">
	    <table border="1">
	        <thead>
	            <tr>
	                <th>방 제목</th>
	                <th>방 지역</th>
	                <th>방 생성자</th>
	                <th>생성 날짜</th>
	                <th>가입하기</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="party" items="${partyList}">
	                <tr>
	                    <td>${party.partyNm}</td>
	                    <td>${party.partyRegion}</td>
	                    <td>${party.userId}</td>
	                    <td>${party.createdAt}</td>
	                    <td>
	                        <!-- 상세 정보로 이동 -->
	                        <a href="partyDetail.jsp?partyIdx=${party.partyIdx}">가입하기</a>
	                    </td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</c:if>
	<c:if test="${empty partyList}">
	    <p>현재 지역에 맞는 모임이 없습니다.</p>
	</c:if>
</body>
</html>