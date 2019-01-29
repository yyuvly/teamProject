<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
<style>

</style>
</head>
	<!-- 상단 로그인바 -->
	<div class="top">
		<c:if test="${empty authInfo}">
			<ul>
				<li><b><a href="<c:url value='/login'/>">LOGIN</a></b>&nbsp;&nbsp;&nbsp;&nbsp;
					<b><a href="<c:url value='/register/step1'/>">JOIN</a></b>&nbsp;&nbsp;&nbsp;&nbsp;
				</li>
			</ul>
		</c:if>

		<c:if test="${!empty authInfo}">
			<ul>
				<li class="tttt"><b>${authInfo.id}</b>님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;
				<b><a href="<c:url value='/mypage/${authInfo.id}'/>">MYPAGE</a></b>&nbsp;&nbsp;&nbsp;&nbsp;
				<b><a href="<c:url value='/goods/cart/cart/'/>">CART</a></b>&nbsp;&nbsp;&nbsp;&nbsp;
				<b><a href="<c:url value='/logout'/>">LOGOUT</a></b>
				</li>
			</ul>
		</c:if>
	</div>

	<!-- 제목 -->
	<div class="title">
	<a class="image" href="<c:url value="/main" />">
		<img src="<c:url value='/images/main/title.png'/>" alt="사진1" height="auto" width="200"/>
		</a>
	<%-- 	<a href="<c:url value='/main'/>">멍's닷컴</a> --%>
	</div>

	<!-- 메뉴바 -->
	<div class="menu">
		<div class="ui four item menu">
			<a class="item" href="<c:url value='/hotel/reserve'/>">HOTEL</a>
			<a class="item" href="<c:url value='/goods/list'/>">GOODS</a>
			<a class="item" href="<c:url value='/review/list'/>">REVIEW</a>
			<a class="item" href="<c:url value='/inquiry'/>">FAQ</a>
		</div>
	</div>
<%-- 	<div class="menu">
		<ul>
			<li><a href="<c:url value='/hotel/reserve'/>">hotel</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<c:url value='/goods/list'/>">shop</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<c:url value='/inquiry/list'/>">Q&A</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</li>
		</ul>
	</div> --%>
</body>
</html>