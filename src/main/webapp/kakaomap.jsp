<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>카카오맵 연동</title>
    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=58a4a5cfbc781b2348261bdd16809813&libraries=services"></script>
</head>
<body>
<div id="map" style="width:100%;height:400px;"></div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        // 서버에서 전달된 좌표 (기본값 포함)
        var latitude = <%= request.getAttribute("latitude") %> || 37.5665;
        var longitude = <%= request.getAttribute("longitude") %> || 126.9780;

        // 지도 생성
        var mapContainer = document.getElementById('map'); // 지도를 표시할 div
        var mapOption = {
            center: new kakao.maps.LatLng(latitude, longitude), // 서버에서 전달된 좌표로 지도 중심 설정
            level: 3 // 확대 레벨
        };
        var map = new kakao.maps.Map(mapContainer, mapOption);

        // 마커 표시
        var markerPosition = new kakao.maps.LatLng(latitude, longitude);
        var marker = new kakao.maps.Marker({
            position: markerPosition
        });
        marker.setMap(map);

        // 마커에 인포윈도우 추가
        var infowindow = new kakao.maps.InfoWindow({
            content: `<div style="padding:5px;">위치 정보<br>(${latitude}, ${longitude})</div>`
        });
        infowindow.open(map, marker);

        // 지도 클릭 이벤트
        kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
            var latlng = mouseEvent.latLng;

            alert('클릭한 위치의 좌표는 ' + latlng.getLat() + ', ' + latlng.getLng() + '입니다.');

            // 클릭한 위치로 마커 이동
            marker.setPosition(latlng);
            infowindow.setContent(`<div style="padding:5px;">새로운 위치<br>(${latlng.getLat()}, ${latlng.getLng()})</div>`);
        });
    });
</script>

</body>
</html>
