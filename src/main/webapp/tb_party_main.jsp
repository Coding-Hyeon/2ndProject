<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Welcome, ${loginUser.name}!</h1>

    <c:if test="${empty partyList}">
        <p>No available parties in your region.</p>
    </c:if>

    <c:forEach var="party" items="${partyList}">
        <div style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
            <h3>${party.partyNm}</h3>
            <p>Region: ${party.partyRegion}</p>
            <p>Members: ${party.memberCount}</p>
            <p>Created by: ${party.creatorName}</p>
            <a href="partyDetails?partyIdx=${party.partyIdx}">View Details</a>
        </div>
    </c:forEach>

    <a href="logout">Logout</a>
</body>
</html>