<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="change.title" /></title>
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
			<form:form class="ui form">
				<table class="ui celled table">
					<tr>
						<td class="th"><b><spring:message code="currentPassword" /></b></td>
						<td><form:password path="currentPassword" style="border: none"/>
							<form:errors path="currentPassword" /></td>
					</tr>
					<tr>
						<td class="th"><b><spring:message code="newPassword" /></b></td>
						<td><form:password path="newPassword" style="border: none"/>
							<form:errors path="newPassword" /></td>
					</tr>
				</table>
				<br>
				<input class="small ui red button" type="submit" style="float: right;" value="변경하기">
			</form:form>
			<div class="push"></div>
		</div>
		<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
	</div>
</body>
</html>