<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="login" method="post">
        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id" required>
        <br>
        <label for="user_pw">비밀번호:</label>
        <input type="password" id="user_pw" name="user_pw" required>
        <br>
        <button type="submit">로그인</button>
    </form>
    
    <!-- 로그인 실패 메시지 표시 -->
    <c:if test="${param.error == 'invalid'}">
        <p style="color: red;">아이디 또는 비밀번호가 잘못되었습니다. 다시 시도해주세요.</p>
    </c:if>

    <br>
    <a href="register.jsp">회원가입</a> <!-- 회원가입 페이지 링크 -->
</body>
</html>