<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/orders/orders.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="/css/semantic/semantic.min.js"></script>
<c:set var="path" value="${pageContext.request.contextPath}" />
</head>
<body>
<div class="wrap">
<jsp:include page="/WEB-INF/view/top.jsp" flush="false" />
<div class="orderList">
<h3 class="ui header" style="color: red; text-align: center;">o r d e r</h3><br>
	<table class="ui table" border="1">
		<c:forEach var="orderlist" items="${orderItem}" varStatus="loop">
			<tr>
				<td rowspan="7" width="250">
				<c:if test="${orderlist.type eq 'hotel' }"><img src="${path}/images/IMG_9785.jpg"
						style="width: 300px; height: 300px; max" /></c:if>
					<c:if test="${orderlist.type eq 'item' }"><img src="${path}/images/goods/${orderlist.img }"
						style="width: 300px; height: 300px; " /></c:if>	
					
				</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>상품명</b></td>
				<td>${orderlist.item}</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>가격</b></td>
				<td>${orderlist.price}원</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>수량</b></td>
				<td>${orderlist.count}</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>주문유형</b></td>
				<td>${orderlist.type}</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>주문번호</b></td>
				<td>${orderlist.ordernum}</td>
			</tr>
			<tr>
				<td class="th" style="text-align: center;"><b>주문날짜</b></td>
				<td>${orderlist.regdate}</td>
			</tr>
	
			<tr>
				<td colspan="3">
				<a class="small ui red button" href="<c:url value='/review/regist/${orderlist.num}'/>" style="float: right;">후기작성</a>
				<input type="hidden" id="orderNum" value="${orderlist.num}">
				</td>
			</tr>
		</c:forEach>
	</table>
			
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>