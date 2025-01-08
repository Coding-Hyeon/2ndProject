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
        <h1>게시글 수정</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <form action="editPostProcess" method="post" enctype="multipart/form-data">
            <input type="hidden" name="postId" value="1"> <!-- 수정할 게시글 ID -->
            <div>
                <label for="postTitle">글 제목:</label>
                <input type="text" id="postTitle" name="postTitle" value="기존 제목" required>
            </div>
            <div>
                <label for="postContent">글 내용:</label>
                <textarea id="postContent" name="postContent" rows="10" required>기존 내용</textarea>
            </div>
            <div>
                <label for="postImage">이미지 파일:</label>
                <input type="file" id="postImage" name="postImage" accept="image/*">
                <p>현재 이미지: <img src="current-image.jpg" alt="현재 이미지" class="post-image"></p>
            </div>
            <div>
                <button type="submit">글 수정하기</button>
                <button type="button" onclick="confirmDelete()">글 삭제하기</button>
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

    <script>
        function confirmDelete() {
            if (confirm('정말로 이 게시글을 삭제하시겠습니까?')) {
                location.href = 'deletePostProcess?postId=1';
            }
        }
    </script>
</body>
</html>