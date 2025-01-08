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
        <h1>모임 찾기</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <section>
            <div>
                <button onclick="location.href='createParty.jsp'">모임 방 생성</button>
            </div>

            <h2>추천 모임 방</h2>
            <div id="party-list">
                <!-- Sample Party Room -->
                <div class="party-room">
                    <img src="sample-image.jpg" alt="모임 이미지" class="party-image">
                    <h3 class="party-title">모임 방 제목</h3>
                    <p class="party-creator">방장: 홍길동</p>
                    <p class="party-region">지역: 서울</p>
                    <p class="party-members">가입자 수: 10명</p>
                    <button onclick="viewPartyDetails(1)">가입하기</button>
                </div>
                <!-- Add dynamic content here with server-side rendering or AJAX -->
            </div>
        </section>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>

    <script>
        function viewPartyDetails(partyId) {
            // Redirect to party details page
            location.href = `partyDetails.jsp?partyId=${partyId}`;
        }
    </script>
</body>
</html>