<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>모임 위치 글쓰기</title>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=58a4a5cfbc781b2348261bdd16809813&libraries=services"></script>
    <script>
        function initMap() {
            const container = document.getElementById('map'); // 맵을 표시할 div
            const options = {
                center: new kakao.maps.LatLng(37.5665, 126.9780), // 기본 지도 중심 좌표 (서울)
                level: 3 // 확대 수준
            };
            const map = new kakao.maps.Map(container, options);

            // 클릭 이벤트로 마커 생성
            kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
                const latlng = mouseEvent.latLng;

                // 마커가 이미 있다면 제거
                if (window.marker) {
                    window.marker.setMap(null);
                }

                // 새로운 마커 추가
                const marker = new kakao.maps.Marker({
                    position: latlng
                });
                marker.setMap(map);
                window.marker = marker;

                // 위도와 경도를 input 필드에 설정
                document.getElementById('latitude').value = latlng.getLat();
                document.getElementById('longitude').value = latlng.getLng();
            });
        }
    </script>
</head>
<body onload="initMap()">
    <h1>모임 위치 글쓰기</h1>
    <form action="locationPostProcessServlet" method="post">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="content">내용:</label><br>
        <textarea id="content" name="content" rows="10" cols="100" required></textarea><br><br>

        <label for="latitude">위도:</label>
        <input type="text" id="latitude" name="latitude" readonly><br>

        <label for="longitude">경도:</label>
        <input type="text" id="longitude" name="longitude" readonly><br><br>

        <div id="map" style="width:100%; height:200px; margin-bottom:20px;"></div>

        <button type="submit">글 올리기</button>
    </form>
</body>
</html>
