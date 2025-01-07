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
    <header>
        <button onclick="location.href='mypage.jsp'">마이페이지</button>
        <button onclick="location.href='logout'">로그아웃</button>
    </header>
    <h2>${party.partyNm} - 최신 글</h2>
    <button onclick="location.href='write.jsp?partyIdx=${party.partyIdx}'">글쓰기</button>
    <c:forEach var="post" items="${postList}">
        <div>
            <h3>${post.postNm}</h3>
            <p>${post.postContent}</p>
            <img src="${post.postFile}" alt="글 이미지" width="300"><br>
            <p>작성자: ${post.userId}</p>
            <p>작성일: ${post.createdAt}</p>
            <button>좋아요 (${post.postLike})</button>
            <button onclick="location.href='comment.jsp?postIdx=${post.postIdx}'">댓글 보기</button>
            <c:if test="${post.isAuthor}">
                <button onclick="location.href='updatePost.jsp?postIdx=${post.postIdx}'">수정하기</button>
            </c:if>
        </div>
    </c:forEach>
</body>
</html>