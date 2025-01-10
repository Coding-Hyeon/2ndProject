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
        <h1>모임 방 수정</h1>
        <nav>
            <button onclick="location.href='myPage.jsp'">마이페이지</button>
            <button onclick="location.href='logoutProcess'">로그아웃</button>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
 <form action="editPartyProcess" method="post" enctype="multipart/form-data">
    <input type="hidden" name="partyIdx" value="${party.partyIdx}">
    <div>
        <label for="partyTitle">모임방 제목:</label>
        <input type="text" id="partyTitle" name="partyTitle" value="${party.partyNm}" required>
    </div>
    <div>
        <label for="partyDescription">모임방 소개:</label>
        <textarea id="partyDescription" name="partyDescription" rows="5" required>${party.partyInfo}</textarea>
    </div>
    <div>
        <label for="partyRegion">모임방 지역:</label>
        <input type="text" id="partyRegion" name="partyRegion" value="${party.partyRegion}" required>
    </div>
    <div>
        <label for="partyImage">이미지 파일:</label>
        <input type="file" id="partyImage" name="partyImage" accept="image/*">
        <p>현재 이미지: <img src="${party.partyFile}" alt="현재 이미지" class="party-image"></p>
    </div>
    <div>
        <label for="partyNotice">공지사항:</label>
        <textarea id="partyNotice" name="partyNotice" rows="5">${party.partyNotice}</textarea>
    </div>
    <div>
        <button type="submit">수정 완료</button>
        <button type="button" onclick="confirmDelete()">삭제하기</button>
        <a href="deletePartyProcess?partyIdx=${party.partyIdx}">모임 삭제</a>
    </div>
</form>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 YourWebsite</p>
    </footer>

    <script>
        function confirmDelete() {
            if (confirm('정말로 이 모임 방을 삭제하시겠습니까?')) {
                location.href = 'deletePartyProcess';
            }
        }
    </script>
    
<script>
    function confirmEditSuccess() {
        alert('수정이 완료되었습니다.');
        location.href = 'partyRoom.jsp';
    }
</script>


</body>
</html>