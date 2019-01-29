<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
													<!-- 에러를 알려주기 위해 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확인</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hotel/confirm.css">
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

<div class="confirm">
<h3 class="ui header" style="color: red; text-align: center;">h o t e l</h3><br><br>
	<form class="ui form" name="pay"
		action="<c:url value="/orders/hotel" />" method="POST">
			<c:if test="${!empty authInfo}">
				<div class="ui column grid" id="grid">
					<div class="ui raised segment">
						<a class="ui red ribbon label">User Info</a>
						<table class="user">
							<tr>
								<th>이름</th>
								<td>${member.name}</td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td>${member.phone}</td>
							</tr>
							<tr>
								<th>주소</th>
								<td>${member.address}</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>${member.email}</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="ui column grid" id="grid">
					<div class="ui raised segment">
						<a class="ui red ribbon label">Pet Info</a>
						<table class="dangdang">
							<tr>
								<th>댕댕이 이름</th>
								<td>${hotelVO.a_name}</td>
							</tr>
							<tr>
								<th>댕댕이 나이</th>
								<td>${hotelVO.a_age}세</td>
							</tr>
							<tr>
								<th>댕댕이 성별</th>
								<td>${hotelVO.a_gender}</td>
							</tr>
							<tr>
								<th>몇 마리?</th>
								<td>${hotelVO.a_cnt}마리</td>
							</tr>
							<tr>
								<th>체크인 시간</th>
								<td>${hotelVO.checkin}</td>
							</tr>
							<tr>
								<th>체크아웃 시간</th>
								<td>${hotelVO.checkout}</td>
							</tr>
							<tr>
								<th>총 금액</th>
								<td>${hotelVO.price}원</td>
							</tr>
						</table>
					</div>
				</div>

				<div class="inline fields">
					<label for="payment">결제 방식을 선택하세요.</label>
					<div class="field" style="padding-left: 20px;">
						<div class="ui radio checkbox">
							<input type="radio" name="payment" value="true"
								required="required"> <label style="padding-right: 20px;">계좌이체</label>
						</div>
					</div>
					<br> <br>
					<div class="field">
						<div class="ui radio checkbox">
							<input type="radio" name="payment" value="false"
								required="required"> <label>신용카드</label>
						</div>
					</div>
				</div>
				<a class="small ui yellow button" href="<c:url value="/hotel/reserve"/>" style="float: right;">돌아가기</a>
				<input class="small ui red button" type="submit" style="float: right;" value="결제하기">
			</c:if>

			<c:if test="${empty authInfo}">
				<p>로그인 후 이용가능합니다.</p>
				<p>
					<a href="<c:url value='/login'/>">[로그인하러 가기]</a>
				</p>
			</c:if>
			<%-- <td><a href="<c:url value="/inquiry/read/${inquiry.num}"/>">${inquiry.item}</a></td> --%>
	</form>
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>