<%@page import="com.smhrd.model.PostVO"%>
<%@page import="com.smhrd.model.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    int postIdx = Integer.parseInt(request.getParameter("postIdx"));
    PostDAO postDAO = new PostDAO();
    PostVO post = postDAO.getPostById(postIdx);
%>
<div>
    <h1><%= post.getPostNm() %></h1>
    <p><%= post.getPostContent() %></p>
    <% if (post.getPostFile() != null) { %>
        <img src="uploads/<%= post.getPostFile() %>" alt="Post Image">
    <% } %>
    <p>작성자: <%= post.getUserId() %></p>
    <p>작성일: <%= post.getCreatedAt() %></p>
</div>
</body>
</html>