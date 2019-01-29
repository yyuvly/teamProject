<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>총 주문목록</title>
<c:set var="path" value="${pageContext.request.contextPath}" />
</head>
<body>
	<table border="1">
		<tr>
			<th>번호(num)</th>
			<th>종류(type)</th>
			<th>썸네일(img)</th>
			<th>상품명(item)</th>
			<th>수량(count)</th>
			<th>단가(price)</th>
			<th>합계(sum)</th>
		</tr>
		<c:forEach var="orders" items="${ordersList}" varStatus="loop">
			<tr>
				<td>${orders.num}</td>
				<td>${orders.type}</td>
				<td height="100px"><img src="${path}/images/${orders.img}"
					style="width: auto; height: auto; max-width: 90px; max-height: 90px" /></td>
				<td>${orders.item}</td>
				<td>${orders.count}</td>
				<td>${orders.price}</td>
				<td>${orders.count * orders.price}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pagemaker.prev}">
		<a href="${path}/orders/list?pageNum=${pagemaker.start-1}">prev</a>
	</c:if>
	<c:forEach begin="${pagemaker.start}" end="${pagemaker.end}" var="nm">
		<a href="${path}/orders/list?pageNum=${nm}">${nm}</a>
	</c:forEach>
	<c:if test="${pagemaker.next}">
		<a href="${path}/orders/list?pageNum=${pagemaker.end+1}">next</a>
	</c:if>
</body>
</html>