<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문서 작성</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/orders/orders.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="/css/semantic/semantic.min.js"></script>

</head>
<body>
<div class="wrap">
<jsp:include page="/WEB-INF/view/top.jsp" flush="false" />

	<div class="payment">
	<h3 class="ui header" style="color: red; text-align: center;">C r e a t i n g &nbsp;&nbsp;&nbsp;a n &nbsp;&nbsp;&nbsp;O r d e r</h3><br>
	<form:form class="ui form" action="itemConfirm" commandName="orderData">
		<div class="ui pointing below red basic label">예약 정보 확인</div>
	
		<table class="ui celled red table" style="text-align: center;">
		<thead>
			<tr>
				<th>주문 내역</th>
				<th>총 결제 금액</th>
			</tr>
		<tbody>
			<tr>
				<td>
					<c:if test="${ItemNum eq 1}">
						${item} 주문
					</c:if>
					<c:if test="${ItemNum ne 1}">
						${item} 외 ${ItemNum-1}개 주문
					</c:if>
				</td>
				<td>${total}원</td>
			</tr>
		</tbody>
		</table>

		<br><br>
		<div class="ui pointing below red basic label">배송지 정보 확인</div>
		<table class="ui celled table">
			<tr>
				<td class="th" style="text-align: center;"><b>수취인</b></td>
				<td>${member.name}</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>주소</b></td>
				<td>${member.address}</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>연락처</b></td>
				<td>${member.phone}</td>
			</tr>
		</table>
		<br><br>

		<div class="ui pointing below red basic label">결제 정보 입력</div>
		<form:form class="ui form" action="hotelConfirm" commandName="orderData">
			<div class="field">
				<label>카드사명</label>
				<form:input path="info" placeholder="카드사명" required="required" />
			</div>
			<div class="field">
				<label>카드번호</label>
				<form:input path="account" placeholder="카드번호" required="required" />
			</div>
			<div class="field">
				<label>서명</label>
				<form:input path="name" placeholder="서명" required="required" />
			</div>
		<br>
		<button class="small ui red button" type="submit" style="float: right;">결제하기</button>
		</form:form>
	</form:form>
	</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>
