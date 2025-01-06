<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>마이페이지</h1>
    <form action="updateUser" method="post">
        <label>ID: </label>
        <span>${loginUser.id}</span><br>

        <label>성별: </label>
        <span>${loginUser.gender}</span><br>

        <label>나이: </label>
        <span>${loginUser.date}</span><br>

        <label>이름: </label>
        <input type="text" name="name" value="${loginUser.name}" required><br>

        <label>비밀번호: </label>
        <input type="password" name="pw" required><br>

        <label>지역: </label>
        <input type="text" name="region" value="${loginUser.region}" required><br>

        <button type="submit">수정</button>
    </form>

    <form action="deleteUser" method="post" onsubmit="return confirm('정말 회원 탈퇴를 진행하시겠습니까?');">
        <button type="submit" style="color: red;">회원 탈퇴</button>
    </form>

    <!-- 성공/오류 메시지 -->
    <c:if test="${param.error == 'duplicateName'}">
        <p style="color: red;">이름이 중복되었습니다. 다른 이름을 입력하세요.</p>
    </c:if>
    <c:if test="${param.success == 'update'}">
        <p style="color: green;">회원 정보가 수정되었습니다.</p>
    </c:if>
    <c:if test="${param.error == 'updateFail'}">
        <p style="color: red;">회원 정보 수정에 실패했습니다. 다시 시도하세요.</p>
    </c:if>
    <c:if test="${param.error == 'deleteFail'}">
        <p style="color: red;">회원 탈퇴에 실패했습니다. 다시 시도하세요.</p>
    </c:if>
    <c:if test="${param.success == 'delete'}">
        <p style="color: green;">회원 탈퇴가 완료되었습니다. 감사합니다.</p>
    </c:if>
</body>
</html>