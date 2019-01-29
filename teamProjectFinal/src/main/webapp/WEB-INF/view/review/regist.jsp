<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
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
<h3 class="ui header" style="color: red; text-align: center;">r e v i e w</h3><br>
<form class="ui form" method="post">
	<table class="ui table" border="1">
		<tr>
			<td rowspan="5" width="150">
			<c:if test="${OrderList.type eq 'hotel' }"><img src="${path}/images/IMG_9785.jpg"
						style="width: 150px; height: 150px; margin:auto; " /></c:if>
					<c:if test="${OrderList.type eq 'item' }"><img src="${path}/images/goods/${OrderList.img }"
						style="width: 150px; height: 150px; margin:auto;" /></c:if>	
			</td>
		</tr>
		<tr>
			<td class="th" style="text-align: center;"><b>작성자</b></td>
			<td>${OrderList.id}</td>
		</tr>
		<tr>
			<td class="th" style="text-align: center;"><b>물품명</b></td>
			<td>${OrderList.item}</td>
		</tr>
		<tr>
			<td class="th" style="text-align: center;"><b>수량</b></td>
			<td>${OrderList.count}</td>
		</tr>
		<tr>
			<td class="th" style="text-align: center;"><b>구매유형</b></td>
			<td>${OrderList.type}</td>
		</tr>
		<tr>
			<td colspan="3">
			<textarea name="content" required="required" style="height: 200px; border: none; resize: none;"></textarea></td>
		</tr>
	</table>
	<br>
	<a class="small ui yellow button" href="<c:url value="/orders/ordersDetail"/>" style="float: right;">목록</a>
		<input type="hidden" name="id" value="${OrderList.id}"> 
		<input type="hidden" name="img" value="${OrderList.img}"> 
		<input type="hidden" name="item" value="${OrderList.item}"> 
		<input type="hidden" name="ordernum" value="${OrderList.ordernum}"> 
		<input type="hidden" name="type" value="${OrderList.type}">
	<button class="small ui red button" type="submit" style="float: right;">등록</button>
	</form>	
	</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>


