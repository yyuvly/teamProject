<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3; URL=${pageContext.request.contextPath}/main">
<title><spring:message code="delete.title"/></title>
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
		<h3 class="ui header" style="color: red; text-align: center;">s u c c e s s</h3><br>
		<form>
			<p>
				<spring:message code="delete.done" />
			</p>
			<p>
				<b>[ 3초 후 메인으로 이동합니다 ]</b>
			</p>
		</form>
		</div>
		<div class="push"></div>
		<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
	</div>
</body>
</html>





