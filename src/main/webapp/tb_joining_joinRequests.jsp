<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Join Requests for ${party.partyNm}</h1>

    <c:if test="${empty joinRequests}">
        <p>No pending join requests.</p>
    </c:if>

    <c:forEach var="request" items="${joinRequests}">
        <div style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
            <p>Name: ${request.userName}</p>
            <p>Introduction: ${request.joinIntro}</p>
            <form action="manageJoinRequests" method="post">
                <input type="hidden" name="joinIdx" value="${request.joinIdx}">
                <button type="submit" name="action" value="accept">Accept</button>
                <button type="submit" name="action" value="reject">Reject</button>
            </form>
        </div>
    </c:forEach>
</body>
</html>