<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 목록</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/review/review.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="/css/semantic/semantic.min.js"></script>

<c:set var="path" value="${pageContext.request.contextPath}" />
</head>
<body>
<div class="wrap">
<jsp:include page="/WEB-INF/view/top.jsp" flush="false" />

<div class="review">
<h3 class="ui header" style="color: red; text-align: center;">r e v i e w &nbsp;&nbsp;&nbsp;l i s t<br>- a l l -</h3><br>
<a class="small ui red button" href="<c:url value="/review/list"/>" >all</a>
<a class="small ui yellow button" href="<c:url value="/review/hotel"/>" >hotel</a>
<a class="small ui yellow button" href="<c:url value="/review/goods"/>" >goods</a><br>
	
	<table class="ui celled red table">
		<thead>
			<tr>
				<th style="text-align: center; width: 10%;">번호</th>
				<th style="text-align: center; width: 10%;">종류</th>
				<th style="text-align: center; width: 10%;">사진</th>
				<th style="text-align: center; width: 20%;">상품명 / 예약날짜</th>
				<th style="text-align: center; width: 10%;">아이디</th>
				<th style="text-align: center; width: 40%;">한줄평</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="review" items="${reviewList}" varStatus="loop">
				<tr>
					<td style="text-align: center;">${review.num}</td>
					<td style="text-align: center;">${review.type}</td>
					<td style="text-align: center;">
					<c:if test="${review.type eq 'hotel' }"><img src="${path}/images/IMG_9785.jpg"
						style="width: auto; height: auto; max-width: 50px; max-height: 50px" /></c:if>
					<c:if test="${review.type eq 'item' }"><img src="${path}/images/goods/${review.img }"
						style="width: auto; height: auto; max-width: 50px; max-height: 50px" /></c:if>	
						</td>
					<td>${review.item}</td>
					<td style="text-align: center;">${review.id}</td>
					<td>${review.content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div style="text-align: center;">
	<c:if test="${pagemaker.prev}">
		<a href="${path}/review/list?pageNum=${pagemaker.start-1}">prev</a>
	</c:if>
	<c:forEach begin="${pagemaker.start}" end="${pagemaker.end}" var="nm">
		<a href="${path}/review/list?pageNum=${nm}">[ ${nm} ]</a>
	</c:forEach>
	<c:if test="${pagemaker.next}">
		<a href="${path}/review/list?pageNum=${pagemaker.end+1}">next</a>
	</c:if>
	</div>
	
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>