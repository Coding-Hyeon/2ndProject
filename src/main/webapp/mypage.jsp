<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script>
        // 이름 중복 확인 AJAX
        function checkNameDuplicate() {
            const name = document.getElementById("name").value.trim();
            if (name === "") {
                alert("이름을 입력해주세요.");
                return;
            }

            const xhr = new XMLHttpRequest();
            xhr.open("POST", "checkNameDuplicate", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    const response = xhr.responseText.trim();
                    if (response === "true") {
                        alert("이미 사용 중인 이름입니다.");
                    } else {
                        alert("사용 가능한 이름입니다.");
                    }
                }
            };
            xhr.send("name=" + encodeURIComponent(name));
        }
    </script>
</head>
<body>
    <header>
        <button onclick="location.href='main.jsp'">메인으로</button>
        <button onclick="location.href='logout'">로그아웃</button>
    </header>
    <h2>마이페이지</h2>
    <form action="updateUser" method="post">
        <table>
            <tr>
                <td>아이디:</td>
                <td>${loginUser.id}</td>
            </tr>
            <tr>
                <td>이름:</td>
                <td>
                    <input type="text" id="name" name="name" value="${loginUser.name}" required>
                    <button type="button" onclick="checkNameDuplicate()">중복 확인</button>
                </td>
            </tr>
            <tr>
                <td>비밀번호:</td>
                <td>
                    <input type="password" id="pw" name="pw" value="${loginUser.pw}" required>
                </td>
            </tr>
            <tr>
                <td>나이:</td>
                <td>${loginUser.date}</td>
            </tr>
            <tr>
                <td>지역:</td>
                <td>
                    <input type="text" id="region" name="region" value="${loginUser.region}" required>
                </td>
            </tr>
            <tr>
                <td>가입일:</td>
                <td>${loginUser.time}</td>
            </tr>
        </table>
        <button type="submit">정보 수정</button>
    </form>
</body>
</html>