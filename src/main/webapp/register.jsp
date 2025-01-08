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
        <h1>회원가입 페이지</h1>
    </header>

    <!-- Registration Form -->
    <main>
        <form action="registerProcess" method="post">
            <div>
                <label for="userId">아이디:</label>
                <input type="text" id="userId" name="userId" required>
                <button type="button" onclick="checkIdDuplicate()">중복확인</button>
            </div>
            <div>
                <label for="userPw">비밀번호:</label>
                <input type="password" id="userPw" name="userPw" required>
            </div>
            <div>
                <label for="userNm">이름:</label>
                <input type="text" id="userName" name="userName" required>
            </div>
            <div>
                <label for="userGender">성별:</label>
                <select id="userGender" name="userGender" required>
                    <option value="M">남</option>
                    <option value="F">여</option>
                </select>
            </div>
            <div>
                <label for="userAge">생년월일:</label>
                <input type="date" id="userAge" name="userAge" required>
            </div>
            <div>
                <label for="userRegion">지역:</label>
                <input type="text" id="userRegion" name="userRegion" required>
            </div>
            <div>
                <button type="submit">가입하기</button>
            </div>
        </form>
        <div>
            <button onclick="location.href='login.jsp'">로그인 페이지로</button>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>

    <script>
    <script>
    function checkDuplicateId() {
        const userId = document.getElementById("userId").value;
        if (!userId) {
            document.getElementById("idCheckResult").innerText = "아이디를 입력하세요.";
            return;
        }

        const xhr = new XMLHttpRequest();
        xhr.open("GET", `checkId?userId=${userId}`, true);
        xhr.onload = function () {
            if (xhr.status === 200) {
                document.getElementById("idCheckResult").innerText = xhr.responseText;
            }
        };
        xhr.send();
    }
</script>
    </script>
</body>
</html>