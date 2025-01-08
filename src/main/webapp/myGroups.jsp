<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <header>
        <button onclick="location.href='main.jsp'">메인으로</button>
        <button onclick="location.href='logout'">로그아웃</button>
    </header>
    <h2>나의 모임</h2>

    <c:if test="${myGroups != null && !myGroups.isEmpty()}">
        <table border="1">
            <thead>
                <tr>
                    <th>모임 이름</th>
                    <th>방장</th>
                    <th>가입일</th>
                    <th>모임 상세</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="group" items="${myGroups}">
                    <tr>
                        <td>${group.partyNm}</td>
                        <td>${group.ownerName}</td>
                        <td>${group.joinedAt}</td>
                        <td>
                            <button onclick="location.href='partyDetails.jsp?partyIdx=${group.partyIdx}'">상세 보기</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${myGroups == null || myGroups.isEmpty()}">
        <p>가입한 모임이 없습니다.</p>
    </c:if>
</body>
</html>