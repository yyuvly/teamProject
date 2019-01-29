<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="delete.title" /></title>
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
			<h3 class="ui header" style="color: red; text-align: center;">d r o p &nbsp;&nbsp;&nbsp;o u t</h3><br>
			<form:form>
				<label>정말 탈퇴하시겠습니까?</label><br><br>
				
				<b>비밀번호 : </b>
					<form:password path="confirmPassword" style="border:0;border-bottom: 1px solid black;"/>
					<form:errors path="confirmPassword" />
				<br><br><br>
				<button class="small ui red button" type="submit">탈퇴</button>
			</form:form>
			<div class="push"></div>
		</div>
		<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
	</div>
</body>
</html>





