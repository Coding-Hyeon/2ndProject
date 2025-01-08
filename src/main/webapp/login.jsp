<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- Header -->
    <header>
        <h1>로그인 페이지</h1>
    </header>

    <!-- Login Form -->
    <main>
        <form action="loginProcess" method="post">
            <div>
                <label for="userId">아이디:</label>
                <input type="text" id="userId" name="userId" required>
            </div>
            <div>
                <label for="userPw">비밀번호:</label>
                <input type="password" id="userPw" name="userPw" required>
            </div>
            <div>
                <button type="submit">로그인</button>
            </div>
        </form>
        <div>
            <button onclick="location.href='register.jsp'">회원가입</button>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>
</body>
</html>