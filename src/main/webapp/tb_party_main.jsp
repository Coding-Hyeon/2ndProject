<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Main Page</h1>

    <c:forEach var="party" items="${partyList}">
        <div style="border: 1px solid black; margin: 10px; padding: 10px;">
            <h3>${party.partyNm}</h3>
            <p>Created by: ${party.creatorName}</p>
            <p>Region: ${party.partyRegion}</p>
            <p>Members: ${party.memberCount}</p>
            <p>${party.partyInfo}</p>
            <a href="partyDetails?partyIdx=${party.partyIdx}">View Details</a>
        </div>
    </c:forEach>
</body>
</html>