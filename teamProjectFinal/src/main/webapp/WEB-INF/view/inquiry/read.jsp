<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>"${inquiryVO.item}"&nbsp의 내용입니다.</title>
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
<h3 class="ui header" style="color: red; text-align: center;">r e a d</h3><br>
<div style="text-align: right;">
<c:if test="${authInfo.id eq 'admin'}">
<b>[ <a href="<c:url value="/inquiry/reply/${inquiryVO.num}"/>">답글</a> ]&nbsp;</b>
</c:if>

<c:if test="${not empty authInfo.id }">
<b>[ <a href="<c:url value="/inquiry/edit/${inquiryVO.num}"/>">수정</a> ]&nbsp;</b>
<b>[ <a href="<c:url value="/inquiry/delete/${inquiryVO.num}"/>">삭제</a> ]&nbsp;</b>
</c:if>
<b>[ <a href="<c:url value="/inquiry/list"/>">목록</a> ]</b>
</div>

<%-- 	<div>
		<c:if test="${authInfo.id eq 'admin'}">
			<button onclick="window.location.href='${pageContext.request.contextPath}/inquiry/reply/${inquiryVO.num}'">답글</button>
		</c:if>
		<a href="<c:url value="/inquiry/reply/${inquiryVO.num}"/>">답글</a>
		<a href="<c:url value="/inquiry/edit/${inquiryVO.num}"/>">수정</a>
		<a href="<c:url value="/inquiry/delete/${inquiryVO.num}"/>">삭제</a>
		<a href="<c:url value="/inquiry/list/"/>">목록</a>
	</div> --%>


	<table class="ui celled table">
		<tr>
			<td class="th"><b>작성자</b></td>
			<td>${inquiryVO.name}</td>
			<td class="th"><b>분류</b></td>
			<td>${inquiryVO.type}</td>
		</tr>
		<tr>
			<td class="th"><b>제목</b></td>
			<td>${inquiryVO.item}</td>
			<td class="th"><b>날짜</b></td>
			<td>${inquiryVO.regDate}</td>
		</tr>
		<tr style="height: 200px;">
			<td class="th"><b>내용</b></td>
			<td colspan="3">${inquiryVO.content}</td>
		</tr>
	</table>

</div>	
	
	
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>