<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 

<title>상품 리스트</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/goods/goods.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">

<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="/css/semantic/semantic.min.js"></script>
<style>
ul {
	margin-top:12px;
	margin-bottom:12px;
}
</style>

</head>
<body>

<div class="wrap">
<jsp:include page="/WEB-INF/view/top.jsp" flush="false" />

<div class="goods">
<h3 class="ui header" style="color: red; text-align: center;">g o o d s</h3><br>

  <div class="admin" style="text-align: center;">
		<c:if test="${authInfo.id eq 'admin'}">
			<br><br><button class="small ui red button" onclick="window.location.href='${pageContext.request.contextPath}/goods/regist'">물품 등록</button>
		</c:if>
  </div>
  <hr>
  
  <div class="row">
  <c:forEach var="goods" items="${goodsList }" varStatus="loop">
    <div class="col-sm-4">
 <div class="ui card">
  <a class="image" href="<c:url value="/goods/detail/${goods.num}" />">
    <img src="<spring:url value='/images/goods/${goods.img}'/>"/>
  </a>
  <div class="content">
    <a class="header" href="<c:url value="/goods/detail/${goods.num}" />">${goods.item}</a>
    <div class="meta">
      <a>${goods.price}원</a>
    </div>
  </div>
</div>
  </div>
  </c:forEach>
  </div>
<hr>
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>