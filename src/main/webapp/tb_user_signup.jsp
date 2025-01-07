<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Sign Up</h1>
    <form action="SignupController" method="post">
        <label for="id">User ID:</label>
        <input type="text" name="id" id="id" required>
        <br>
        <label for="pw">Password:</label>
        <input type="password" name="pw" id="pw" required>
        <br>
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required>
        <br>
        <label for="gender">Gender:</label>
        <input type="text" name="gender" id="gender" required>
        <br>
        <label for="date">Birth Date:</label>
        <input type="date" name="date" id="date" required>
        <br>
        <label for="region">Region:</label>
        <input type="text" name="region" id="region" required>
        <br>
        <button type="submit">Sign Up</button>
    </form>
</body>
</body>
</html>