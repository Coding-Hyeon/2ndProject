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
    <h2>${party.partyNm} - 글 작성</h2>
    <form action="createPost" method="post" enctype="multipart/form-data">
        <input type="hidden" name="partyIdx" value="${party.partyIdx}">
        <label for="postNm">제목:</label>
        <input type="text" id="postNm" name="postNm" required><br><br>
        <label for="postContent">내용:</label>
        <textarea id="postContent" name="postContent" required></textarea><br><br>
        <label for="postFile">이미지:</label>
        <input type="file" id="postFile" name="postFile"><br><br>
        <button type="submit">작성 완료</button>
    </form>
</body>
</html>