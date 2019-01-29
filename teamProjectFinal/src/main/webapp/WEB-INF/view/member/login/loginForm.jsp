<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title><spring:message code="login.title" /></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member/login.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="/css/semantic/semantic.min.js"></script>

</head>
<body>
<jsp:include page="/WEB-INF/view/top.jsp" flush="false" />

	<form:form class="ui form" commandName="loginCommand" method="POST">
		<div class="login">
		<h3 class="ui header" style="color: red; text-align: center;">l o g i n</h3><br>
			<div class="field">
				<label class="label">id</label>
				<form:input path="id" placeholder="id" required="required" />
				<form:errors path="id" />
			</div>
			<div class="field">
				<label color="#e92126">password</label>
				<form:password path="password" placeholder="password" required="required" />
				<form:errors path="password" />
			</div>
			<div class="field">
				<div class="ui checkbox">
					<form:checkbox path="rememberId" />
					<label><spring:message code="rememberId" /></label>
				</div>
			</div>
			<button class="small ui red button" type="submit" style="float: right;">로그인</button>
		</div>
	</form:form>

	<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</body>
</html>





