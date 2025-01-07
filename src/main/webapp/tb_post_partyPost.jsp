<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Posts in ${partyName}</h1>

    <c:forEach var="post" items="${postList}">
        <div style="border: 1px solid black; padding: 10px; margin: 10px;">
            <h3>
                <a href="postDetails?postIdx=${post.postIdx}">${post.postNm}</a>
            </h3>
            <p>By: ${post.userId}, Created At: ${post.createdAt}</p>
            <p>Views: ${post.postViews}, Likes: ${post.postLike}</p>
        </div>
    </c:forEach>

    <a href="createPost.jsp?partyIdx=${partyIdx}">Create New Post</a>
    <a href="tb_joining_partyDetails.jsp?partyIdx=${partyIdx}">Back to Party</a>
</body>
</html>