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
        <h1>모임 방 생성</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <form action="createPartyProcess" method="post" enctype="multipart/form-data">
            <div>
                <label for="partyTitle">모임방 제목:</label>
                <input type="text" id="partyTitle" name="partyTitle" required>
            </div>
            <div>
                <label for="partyDescription">모임방 소개:</label>
                <textarea id="partyDescription" name="partyDescription" rows="5" required></textarea>
            </div>
            <div>
                <label for="partyImage">이미지 파일:</label>
                <input type="file" id="partyImage" name="partyImage" accept="image/*">
            </div>
            <div>
                <label for="partyRegion">모임방 지역:</label>
                <input type="text" id="partyRegion" name="partyRegion" required>
            </div>
            <div>
                <button type="submit">방 생성</button>
            </div>
        </form>
        <div>
            <button onclick="location.href='findParty.jsp'">뒤로 가기</button>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>
</body>
</html>