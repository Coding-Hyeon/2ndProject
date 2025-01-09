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
        <h1>게시글 생성</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <form action="createPostProcess" method="post" enctype="multipart/form-data">
        <input type="hidden" name="partyIdx" value="${party.partyIdx}">
            <div>
                <label for="postTitle">글 제목:</label>
                <input type="text" id="postTitle" name="postTitle" required>
            </div>
            <div>
                <label for="postContent">글 내용:</label>
                <textarea id="postContent" name="postContent" rows="10" required></textarea>
            </div>
            <div>
                <label for="postImage">이미지 파일:</label>
                <input type="file" id="postImage" name="postImage" accept="image/*">
            </div>
            <div>
                <button type="submit">글 올리기</button>
            </div>
            
        </form>
        <div>
            <button onclick="location.href='partyRoom.jsp'">뒤로 가기</button>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>
</body>
</html>