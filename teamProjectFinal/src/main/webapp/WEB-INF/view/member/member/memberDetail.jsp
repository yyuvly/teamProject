<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member/profile.css">
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
		<div class="profile">
			<h3 class="ui header" style="color: red; text-align: center;">p r o f i l e</h3><br>
			<table class="ui celled table">
				<tr>
					<td class="th"><b>아이디</b></td>
					<td>${member.id}</td>
				</tr>
				<tr>
					<td class="th"><b>이름</b></td>
					<td>${member.name}</td>
				</tr>
				<tr>
					<td class="th"><b>휴대폰</b></td>
					<td>${member.phone}</td>
				</tr>
				<tr>
					<td class="th"><b>이메일</b></td>
					<td>${member.email}</td>
				</tr>
				<tr>
					<td class="th"><b>주소</b></td>
					<td>${member.address}</td>
				</tr>
			</table>
			<br>
			<a class="small ui yellow button" href="<c:url value='/delete'/>" style="float: right;">회원탈퇴</a>
			<a class="small ui red button" href="<c:url value='/change'/>" style="float: right;">정보수정</a>

		</div>
			<div class="push"></div>
		<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
	</div>
</body>
</html>