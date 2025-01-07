<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Create a New Post</h1>
    <form action="createPost" method="post" enctype="multipart/form-data">
        <label for="postNm">Title:</label>
        <input type="text" name="postNm" id="postNm" required><br>

        <label for="postContent">Content:</label><br>
        <textarea name="postContent" id="postContent" rows="10" cols="50" required></textarea><br>

        <label for="postFile">Attach File:</label>
        <input type="file" name="postFile" id="postFile"><br>

        <input type="hidden" name="partyIdx" value="${partyIdx}">
        <button type="submit">Submit</button>
    </form>
    <a href="partyPosts?partyIdx=${partyIdx}">Back to Posts</a>
</body>
</html>