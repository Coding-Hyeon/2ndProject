<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>${post.postNm}</h1>
    <p>By: ${post.userId}, Created At: ${post.createdAt}</p>
    <p>Views: ${post.postViews}, Likes: ${post.postLike}</p>
    <p>${post.postContent}</p>
    <c:if test="${not empty post.postFile}">
        <p>Attached File: <a href="${post.postFile}" target="_blank">Download</a></p>
    </c:if>

    <c:if test="${loginUser.id == post.userId}">
        <a href="editPost.jsp?postIdx=${post.postIdx}">Edit</a>
        <form action="deletePost" method="post" style="display:inline;">
            <input type="hidden" name="postIdx" value="${post.postIdx}">
            <button type="submit" onclick="return confirm('Are you sure you want to delete this post?');">Delete</button>
        </form>
    </c:if>

    <h2>Comments</h2>
    <c:forEach var="comment" items="${commentList}">
        <div style="border: 1px solid gray; margin: 10px; padding: 10px;">
            <p>${comment.content} by ${comment.userId} on ${comment.createdAt}</p>
            <c:if test="${loginUser.id == comment.userId}">
                <form action="deleteComment" method="post" style="display:inline;">
                    <input type="hidden" name="commentIdx" value="${comment.commentIdx}">
                    <button type="submit" onclick="return confirm('Are you sure you want to delete this comment?');">Delete</button>
                </form>
            </c:if>
        </div>
    </c:forEach>

    <h3>Add a Comment</h3>
    <form action="createComment" method="post">
        <textarea name="content" rows="5" cols="50" required></textarea><br>
        <input type="hidden" name="postIdx" value="${post.postIdx}">
        <button type="submit">Add Comment</button>
    </form>
    <a href="partyPosts?partyIdx=${post.partyIdx}">Back to Posts</a>
</body>
</html>