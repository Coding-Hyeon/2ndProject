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
    <h2>${post.postNm} - 댓글</h2>
    <p>${post.postContent}</p>
    <img src="${post.postFile}" alt="글 이미지" width="300"><br>
    <h3>댓글</h3>
    <c:forEach var="comment" items="${commentList}">
        <div>
            <p>${comment.content}</p>
            <p>작성자: ${comment.userId}</p>
            <p>작성일: ${comment.createdAt}</p>
            <c:if test="${comment.isAuthor}">
                <button onclick="location.href='deleteComment.jsp?commentIdx=${comment.commentIdx}'">삭제</button>
            </c:if>
        </div>
    </c:forEach>
    <form action="createComment" method="post">
        <input type="hidden" name="postIdx" value="${post.postIdx}">
        <textarea name="content" required></textarea><br>
        <button type="submit">댓글 작성</button>
    </form>
</body>
</html>