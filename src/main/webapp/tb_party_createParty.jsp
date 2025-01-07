<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Create a New Party</h1>
    <form action="createParty" method="post" enctype="multipart/form-data">
        <!-- 모임 이름 입력 -->
        <label for="party_nm">Party Name:</label>
        <input type="text" id="party_nm" name="party_nm" required><br><br>

        <!-- 모임 설명 입력 -->
        <label for="party_info">Party Info:</label><br>
        <textarea id="party_info" name="party_info" rows="5" cols="50" required></textarea><br><br>

        <!-- 지역 선택 -->
        <label for="party_region">Party Region:</label>
        <select id="party_region" name="party_region" required>
            <option value="Seoul">Seoul</option>
            <option value="Busan">Busan</option>
            <option value="Incheon">Incheon</option>
            <option value="Daegu">Daegu</option>
            <option value="Daejeon">Daejeon</option>
            <option value="Gwangju">Gwangju</option>
        </select><br><br>

        <!-- 파일 업로드 -->
        <label for="party_file">Upload File:</label>
        <input type="file" id="party_file" name="party_file" accept="image/*,application/pdf"><br><br>

        <!-- 제출 버튼 -->
        <button type="submit">Create Party</button>
    </form>
</body>
</html>