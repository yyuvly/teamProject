<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register" /></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member/register.css">
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

	<form:form class="ui form" action="step3" commandName="formData" method="POST">
		<div class="step2">
			<h3 class="ui header" style="color: red; text-align: center;">j o i n</h3><br>
			<div class="field">
				<label>id</label>
				<form:input path="id" placeholder="id" required="required" />
				<form:errors path="id" />
			</div>
			<div class="field">
				<label>password</label>
				<form:password path="password" placeholder="password" required="required" />
				<form:errors path="password" />
			</div>
			<div class="field">
				<label>confirm password</label>
				<form:password path="confirmPassword" placeholder="confirm password" required="required" />
				<form:errors path="confirmPassword" />
			</div>
			<div class="field">
				<label>name</label>
				<form:input path="name" placeholder="name" required="required" />
				<form:errors path="name" />
			</div>
			<div class="field">
				<label>phone</label>
				<form:input path="phone" placeholder="phone" required="required" />
				<form:errors path="phone" />
			</div>
			<div class="field">
				<label>address</label>
				<form:input path="address" placeholder="address" required="required" />
				<form:errors path="address" />
			</div>
			<div class="field">
				<label>email</label>
				<form:input path="email" placeholder="email" required="required" />
				<form:errors path="email" />
			</div>
			<br>
			<input class="small ui yellow button" type="reset" style="float: right;" value="다시쓰기">
			<input class="small ui red button" type="submit" style="float: right;" value="가입">
		</div>
	</form:form>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>