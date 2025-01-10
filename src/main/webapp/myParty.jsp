<%@page import="com.smhrd.model.PartyVO"%>
<%@page import="java.util.List"%>
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
	<h2>나의 모임</h2>
	<table border="1">
	    <thead>
	        <tr>
	            <th>모임 이름</th>
	            <th>모임 정보</th>
	            <th>지역</th>
	            <th>가입된 회원 수</th>
	            <th>모임 방</th>
	        </tr>
	    </thead>
	    <tbody>
	        <% 
	            List<PartyVO> myParties = (List<PartyVO>) request.getAttribute("myParties");
	
	            if (myParties != null && !myParties.isEmpty()) {
	                for (PartyVO party : myParties) {
	                    // party가 null인지 확인
	                    if (party != null) {
	        %>
	            <tr>
	                <td><%= party.getPartyNm() %></td>
	                <td><%= party.getPartyInfo() %></td>
	                <td><%= party.getPartyRegion() %></td>
	                <td><%= party.getMemberCount() %></td>
	                <td><a href="<%= request.getContextPath() %>/partyRoom.jsp?partyIdx=<%= party.getPartyIdx() %>">모임 방으로 가기</a></td>
	            </tr>
	        <% 
	                    } else {
	        %>
	            <tr>
	                <td colspan="5">모임 정보가 없습니다.</td>
	            </tr>
	        <% 
	                    }
	                }
	            } else {
	        %>
	            <tr>
	                <td colspan="5">가입된 승인된 모임이 없습니다.</td>
	            </tr>
	        <% 
	            }
	        %>
	    </tbody>
	</table>
	<div>
        <button onclick="location.href='main.jsp'">뒤로 가기</button>
    </div>
</body>
</html>