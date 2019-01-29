<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member/mypage.css">
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
<div class="mypage">
<h3 class="ui header" style="color: red; text-align: center;">m y p a g e</h3><br>
	<table border="0">
	
	<tr>
         <td onClick="location.href='${pageContext.request.contextPath}/memberDetail/${authInfo.id }'" style="cursor:pointer;">profile<br><b>회원정보</b></a></td>
         <td onClick="location.href='${pageContext.request.contextPath}/ordersDetail/${authInfo.id }'" style="cursor:pointer;">order<br><b>주문내역</b></a></td>
         <td onClick="location.href='${pageContext.request.contextPath}/goods/cart/cart'" style="cursor:pointer;">cart<br><b>장바구니</b></a></td>
      </tr>
	</table>
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>









