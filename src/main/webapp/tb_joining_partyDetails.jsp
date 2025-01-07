<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>${party.partyNm}</h1>
    <p>Created by: ${party.creatorName}</p>
    <p>Region: ${party.partyRegion}</p>
    <p>Members: ${party.memberCount}</p>
    <p>${party.partyInfo}</p>
    <p>Created at: ${party.createdAt}</p>

    <c:if test="${joiningStatus != null && joiningStatus.agreeYn == 'Y'}">
        <p>You are already a member of this party.</p>
    </c:if>

    <c:if test="${joiningStatus == null || joiningStatus.agreeYn == 'N'}">
        <form action="applyJoin" method="post">
            <textarea name="joinIntro" placeholder="Introduce yourself..."></textarea>
            <input type="hidden" name="partyIdx" value="${party.partyIdx}">
            <button type="submit">Apply to Join</button>
        </form>
    </c:if>

    <a href="tb_party_main.jsp">Back to Main</a>
</body>
</html>