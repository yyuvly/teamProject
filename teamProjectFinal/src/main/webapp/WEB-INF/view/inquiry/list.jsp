<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 목록</title>
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

<%-- 	<c:if test="${!empty authInfo}"> --%>
<div class="inquiry">
<h3 class="ui header" style="color: red; text-align: center;">i n q u i r y &nbsp;&nbsp;&nbsp;l i s t</h3><br>
<div style="text-align: right;">
<b>[ <a href="<c:url value="/inquiry/write"/>">글쓰기</a> ]</b>
</div>

	<table class="ui celled red table">
		<thead>
			<tr>
				<th style="text-align: center;">NO</th>
				<th style="text-align: center;">분류</th>
				<th style="text-align: center; width: 300px;">제목</th>
				<th style="text-align: center;">작성자</th>
				<th style="text-align: center;">조회수</th>
				<th style="text-align: center;">날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(inquiryList)>0}">
					<c:forEach var="inquiry" items="${inquiryList}" varStatus="loop">
						<tr>
							<td style="text-align: center;">${inquiry.num}</td>
							<td style="text-align: center;">${inquiry.type}</td>
							<td>
							<c:if test="${inquiry.rlevel>0}">
								<img src="<c:url value='/images/inquiry/level.gif'/>" width="${10*inquiry.rlevel}"/>
								<img src="<c:url value='/images/inquiry/re.gif'/>" />
							</c:if>
							<a href="<c:url value="/inquiry/read/${inquiry.num}"/>">${inquiry.item}</a>
							<c:if test="${inquiry.cnt>=10}">
								<img src="<c:url value='/images/inquiry/hot.gif'/>"/>
							</c:if>
							</td>			
							<td style="text-align: center;">${inquiry.name}</td>
							<td style="text-align: center;">${inquiry.cnt}</td>
							<td style="text-align: center;">${inquiry.regDate}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="6" style="text-align: center;">작성된 글이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>
		
<%-- 	</c:if> --%>
<%-- 	<c:if test="${empty authInfo}">
		<p>
			로그인 안됐음!! <a href="<c:url value='/main'/>">[메인으로 가기]</a>
		</p>
	</c:if> --%>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>