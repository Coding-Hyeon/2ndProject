<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>${party.partyNm} - Home</h1>
    <p>Region: ${party.partyRegion}</p>
    <p>Members: ${party.memberCount}</p>
    <img src="${party.partyFile}" alt="Party Image" style="max-width: 300px;">
    
    <h2>Introduction</h2>
    <c:if test="${loginUser.id == party.userId}">
        <form action="updatePartyInfo" method="post" enctype="multipart/form-data">
            <textarea name="partyInfo" rows="5" cols="50">${party.partyInfo}</textarea><br>
            <label for="partyFile">Upload Image:</label>
            <input type="file" name="partyFile" id="partyFile"><br>
            <input type="hidden" name="partyIdx" value="${party.partyIdx}">
            <button type="submit">Update</button>
        </form>
    </c:if>
    <c:if test="${loginUser.id != party.userId}">
        <p>${party.partyInfo}</p>
    </c:if>

    <h2>Announcements</h2>
    <c:forEach var="post" items="${announcementList}">
        <div style="border: 1px solid black; margin: 10px; padding: 10px;">
            <h3>${post.postNm}</h3>
            <p>${post.postContent}</p>
            <p>Created At: ${post.createdAt}</p>
        </div>
    </c:forEach>

    <c:if test="${loginUser.id == party.userId}">
        <form action="createAnnouncement" method="post">
            <input type="text" name="postNm" placeholder="Title"><br>
            <textarea name="postContent" placeholder="Write announcement..."></textarea><br>
            <input type="hidden" name="partyIdx" value="${party.partyIdx}">
            <button type="submit">Post Announcement</button>
        </form>
    </c:if>
    
    <h2>Introduction</h2>
	<c:if test="${loginUser.id == party.userId}">
	    <form action="deleteParty" method="post">
	        <input type="hidden" name="partyIdx" value="${party.partyIdx}">
	        <button type="submit" onclick="return confirm('Are you sure you want to delete this party?');">Delete Party</button>
	    </form>
	</c:if>

    <a href="main">Back to Main</a>
</body>
</html>