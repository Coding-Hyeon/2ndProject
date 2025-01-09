<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임 방</title>
</head>
<body>
    <!-- Header -->
    <header>
        <h1>모임 방</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <section class="party-info">
            <h2 id="partyTitle">
                <c:out value="${party.partyNm}" default="모임방 제목 없음" />
            </h2>
            <c:choose>
                <c:when test="${not empty party.partyFile}">
                    <img src="uploads/${party.partyFile}" alt="모임 이미지" class="party-image" style="width:300px;height:200px;">
                </c:when>
                <c:otherwise>
                    <img src="default-image.jpg" alt="기본 이미지" class="party-image" style="width:300px;height:200px;">
                </c:otherwise>
            </c:choose>
            <p class="party-creator">
                <strong>방장:</strong> <c:out value="${party.userId}" default="알 수 없음" />
            </p>
            <p class="party-members">
                <strong>가입자 수:</strong> <c:out value="${party.memberCount}" default="0" />명
            </p>
        </section>

        <section class="party-navigation">
            <button onclick="showTab('home')">홈</button>
            <button onclick="showTab('latestPosts')">최신 글</button>
            <button onclick="showTab('location')">모임 위치</button>
        </section>
        
        

        <section id="home" class="tab-content">
            <h3>방 소개</h3>
            <p>이곳은 모임 방의 소개를 보여줍니다.</p>
            <h3>공지사항</h3>
            <p>공지사항 내용이 여기에 표시됩니다.</p>
            <div id="ownerActions" style="display:none;">
                <button onclick="location.href='editParty.jsp'">수정하기</button>
                <button onclick="location.href='members.jsp'">회원 정보</button>
            </div>
        </section>

        <section id="latestPosts" class="tab-content" style="display:none;">
    	<h2>최신 글</h2>
    	<button onclick="location.href='createPost.jsp'">글 쓰기</button>
    	<div id="posts">
        <!-- 최신 글 출력 -->
        <c:forEach var="post" items="${latestPosts}">
            <div class="post">
                <h3><c:out value="${post.postNm}" /></h3>
                <p>작성자: <c:out value="${post.userId}" /></p>
                <p>내용: <c:out value="${post.postContent}" /></p>
                <c:if test="${not empty post.postFile}">
                    <img src="uploads/${post.postFile}" alt="게시글 이미지">
                </c:if>
                <p>작성일: <c:out value="${post.createdAt}" /></p>
            </div>
        </c:forEach>
   	 	</div>
		</section>

        <section id="location" class="tab-content" style="display:none;">
            <h3>모임 위치</h3>
            <p>아직 미구현입니다.</p>
        </section>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>

    <script>
        function showTab(tabId) {
            const tabs = document.querySelectorAll('.tab-content');
            tabs.forEach(tab => tab.style.display = 'none');

            document.getElementById(tabId).style.display = 'block';
        }

        // 예시: 방장일 경우
        const isOwner = true; // 실제로는 서버에서 이 정보를 받아야 함
        if (isOwner) {
            document.getElementById('ownerActions').style.display = 'block';
        }
    </script>
</body>
</html>