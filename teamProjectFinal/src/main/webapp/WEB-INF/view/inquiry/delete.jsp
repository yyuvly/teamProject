<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 삭제</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inquiry/inquiry.css">
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

<div class="inquiry">
<form name="deleteForm" action="<c:url value="/inquiry/delete"/>" method="POST">
	<h3 class="ui header" style="color: red; text-align: center;">d e l e t e</h3><br>
	<label><input type="hidden" size="1" name="num" value="${num}"/>[ ${num} ] 번 글을 삭제합니다.</label><br><br>
	<b>비밀번호 : </b><input name="password" style="border:0;border-bottom: 1px solid black;"/>
	<br><br><br>
	<input type="submit" class="small ui red button" value="삭제">
	
	<a class="small ui yellow button" href="<c:url value="/inquiry/read/${num}"/>">취소</a>
</form>
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>





