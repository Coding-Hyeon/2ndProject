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
        <h1>마이페이지</h1>
        <nav>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <form action="updateUserProcess" method="post">
            <div>
                <label for="userPw">비밀번호:</label>
                <input type="password" id="userPw" name="userPw" value="기존 비밀번호" required>
            </div>
            <div>
                <label for="userName">이름:</label>
                <input type="text" id="userName" name="userName" value="기존 이름" required>
            </div>
            <div>
                <label for="userGender">성별:</label>
                <input type="text" id="userGender" name="userGender" value="기존 성별" readonly>
            </div>
            <div>
                <label for="userAge">나이:</label>
                <input type="text" id="userAge" name="userAge" value="기존 나이" readonly>
            </div>
            <div>
                <label for="userRegion">지역:</label>
                <input type="text" id="userRegion" name="userRegion" value="기존 지역" required>
            </div>
            <div>
                <button type="submit">수정 완료</button>
                <button type="button" onclick="confirmDelete()">회원 탈퇴</button>
            </div>
        </form>
        <div>
            <button onclick="location.href='main.jsp'">뒤로 가기</button>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>

    <script>
        function confirmDelete() {
            if (confirm('정말로 회원 탈퇴하시겠습니까?')) {
                location.href = 'deleteUserProcess';
            }
        }
    </script>
</body>
</html>