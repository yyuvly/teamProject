<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="/css/semantic/semantic.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
$(document).ready(function(){
	var main = $('.bxslider').bxSlider({
		mode: 'fade',
		auto: true,			// 자동으로 슬라이드
		controls : true,	// 좌우 화살표	
		autoControls: true,	// stop,play
		pager:true,	//페이징
		pause: 3000,
		autoDelay: 0,	
		slideWidth: 1500,
		speed: 500,
		stopAutoOnclick:true
	});
  
	$(".bx-stop").click(function(){ // 중지버튼 눌렀을때
		main.stopAuto();
		$(".bx-stop").hide();
		$(".bx-start").show();
		return false;
	});

	$(".bx-start").click(function(){ // 시작버튼 눌렀을때
	    main.startAuto();
		$(".bx-start").hide();
		$(".bx-stop").show();
		return false;
	});
	
	$(".bx-start").hide(); // onload시 시작버튼 숨김.
});
</script>
</head>
<body>
<div class="wrap">
<jsp:include page="top.jsp" flush="false" />

<div class="main" align="center">
		<div class="bxslider">
			<div><img src="<c:url value='/images/main/main1.jpg'/>" alt="사진1" height="700" width="1500"/></div>
			<div><img src="<c:url value='/images/main/main2.jpg'/>" alt="사진2" height="700" width="1500"/></div>
			<div><img src="<c:url value='/images/main/main3.jpg'/>" alt="사진3" height="700" width="1500"/></div>
			<div><img src="<c:url value='/images/main/main4.jpg'/>" alt="사진4" height="700" width="1500"/></div>
			<div><img src="<c:url value='/images/main/main5.jpg'/>" alt="사진5" height="700" width="1500"/></div>
		</div>
</div>
<div class="push"></div>
<jsp:include page="bottom.jsp" flush="false" />
</div>
</body>
</html>