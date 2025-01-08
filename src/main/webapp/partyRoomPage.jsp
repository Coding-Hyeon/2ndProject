<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            <h2 id="partyTitle">모임방 제목</h2>
            <img src="sample-image.jpg" alt="모임 이미지" class="party-image">
            <p class="party-creator">방장: 홍길동</p>
            <p class="party-members">가입자 수: 10명</p>
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
            <button onclick="location.href='createPost.jsp'">글 쓰기</button>
            <div id="posts">
                <!-- Example Post -->
                <div class="post">
                    <h4>글 제목</h4>
                    <p>작성자: 홍길동</p>
                    <p>글 내용이 여기에 표시됩니다.</p>
                    <img src="post-image.jpg" alt="글 이미지">
                    <p>좋아요 수: 5</p>
                    <p>작성 날짜: 2025-01-01</p>
                    <button onclick="location.href='editPost.jsp?postId=1'">수정하기</button>
                    <button>좋아요</button>
                    <button>공유하기</button>
                    <button onclick="location.href='comments.jsp?postId=1'">댓글 보기</button>
                </div>
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