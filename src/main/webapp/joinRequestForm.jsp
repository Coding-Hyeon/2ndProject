<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/submitJoinRequest" method="post">
	    <input type="hidden" name="partyIdx" value="${partyIdx}">
	    <textarea name="joinIntro" placeholder="소개글을 작성해주세요" required></textarea>
	    <button type="submit" class="btn btn-primary">가입 신청</button>
	</form>
	<div>
        <button onclick="location.href='main.jsp'">뒤로 가기</button>
    </div>
</body>
</html>