<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Edit Post</h1>
    <form action="updatePost" method="post" enctype="multipart/form-data">
        <input type="hidden" name="postIdx" value="${post.postIdx}">
        
        <label for="postNm">Title:</label>
        <input type="text" name="postNm" id="postNm" value="${post.postNm}" required><br>

        <label for="postContent">Content:</label><br>
        <textarea name="postContent" id="postContent" rows="10" cols="50" required>${post.postContent}</textarea><br>

        <label for="postFile">Attach File:</label>
        <input type="file" name="postFile" id="postFile"><br>

        <button type="submit">Update</button>
    </form>
    <a href="postDetails?postIdx=${post.postIdx}">Back to Post</a>
</body>
</html>