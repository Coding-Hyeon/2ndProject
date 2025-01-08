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
        <h1>댓글 작성</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <form action="createCommentProcess" method="post">
            <input type="hidden" name="postId" value="1"> <!-- 댓글이 달릴 게시글 ID -->
            <div>
                <label for="commentContent">댓글 내용:</label>
                <textarea id="commentContent" name="commentContent" rows="5" required></textarea>
            </div>
            <div>
                <button type="submit">확인</button>
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