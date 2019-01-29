<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 등록</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/goods/goods.css">
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

<div class="goods">
<h3 class="ui header" style="color: red; text-align: center;">g o o d s &nbsp;&nbsp;&nbsp;r e g i s t e r</h3><br>
<form:form class="ui form" commandName="goodsVO" method="POST" enctype="multipart/form-data">
		<table class="ui table" border="1">
			<tr>
				<th>주의사항</th>
				<td>
					상품설명은 이미지파일(jpeg, jpg, png)로 첨부하며,<br>
					올리고자 하는 순서대로 이미지파일 이름 앞에 순차적으로 숫자기입<br>
					(ex> 02상품설명.png, 01썸네일.jpg)<br>
					썸네일로 사용할 이미지를 1번으로 설정
					파일다중선택가능
				</td>
			</tr>
			<tr>
				<th><form:label path="item">상품명</form:label></th>
				<td><form:input path="item"/><form:errors path="item"/></td>
			</tr>
			<tr>
				<th><form:label path="price">가격</form:label></th>
				<td><form:input path="price"/><form:errors path="price"/></td>
			</tr>
			<tr>
				<th><form:label path="descript">상품설명</form:label></th>
				<td><input type="file" name="descriptFile" multiple="multiple" accept="image/*"></td>
			</tr>
		</table>
		<div style="float: right;">
			<input class="small ui red button" type="submit" value="등록">
			<a class="small ui yellow button" href="<c:url value="/goods/list"/>">목록</a>
		</div>
	</form:form>
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>