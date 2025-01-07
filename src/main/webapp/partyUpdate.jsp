<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>${party.partyNm} - 정보 수정</h2>
    <form action="updatePartyInfo" method="post" enctype="multipart/form-data">
        <input type="hidden" name="partyIdx" value="${party.partyIdx}">
        <label for="partyNm">방 이름:</label>
        <input type="text" id="partyNm" name="partyNm" value="${party.partyNm}" required><br><br>
        <label for="partyInfo">방 소개:</label>
        <textarea id="partyInfo" name="partyInfo" required>${party.partyInfo}</textarea><br><br>
        <label for="announcement">공지사항:</label>
        <textarea id="announcement" name="announcement">${party.announcement}</textarea><br><br>
        <button type="submit">수정 완료</button>
    </form>
</body>
</html>