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
	<h3 class="ui header" style="color: red; text-align: center;">r e s e r v a t i o n</h3><br>
		<div class="ui pointing below red basic label">예약 정보 확인</div>
		<table class="ui celled red table" style="text-align: center;">
			<thead>
				<tr>
					<th>예약 날짜</th>
					<th>예약 마리 수</th>
					<th>총 결제 금액</th>
				</tr>
			<tbody>
				<tr>
					<td>${date}</td>
					<td>${hotelVO.a_cnt}마리</td>
					<td>${hotelVO.price}원</td>
				</tr>
			</tbody>
		</table>
		
		<br>
		<br>

		<div class="ui pointing below red basic label">결제 정보 입력</div>
		<form:form class="ui form" action="hotelConfirm"
			commandName="orderData">
			<div class="field">
				<label>은행명</label>
				<form:input path="info" placeholder="은행명" required="required" />
			</div>
			<div class="field">
				<label>계좌번호</label>
				<form:input path="account" placeholder="계좌번호" required="required" />
			</div>
			<div class="field">
				<label>입금자명</label>
				<form:input path="name" placeholder="입금자명" required="required" />
			</div>
			<br>
			<button class="small ui red button" type="submit" style="float: right;">결제하기</button>
		</form:form>
	</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>
