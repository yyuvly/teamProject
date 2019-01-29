<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 내역</title>
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
<h3 class="ui header" style="color: red; text-align: center;">g o o d s</h3><br><br><br>


   <div class="admin" style="text-align: center;">
      <c:if test="${authInfo.id eq 'admin'}">
         <button class="small ui red button"
            onclick="window.location.href='${pageContext.request.contextPath}/goods/edit/${goodsVO.num }'">물품수정
         </button>
         <button class="small ui yellow button"
            onclick="window.location.href='${pageContext.request.contextPath}/goods/delete/${goodsVO.num }'">물품삭제
         </button>
      </c:if>
   </div><br>
   <hr>
      <table class="ui table" style="border: 0px;">
         <tr>
            <td rowspan="9" style="padding-right: 40px;">
            <img src="<spring:url value='/images/goods/${goodsVO.img}'/>" width="300" />
            </td>
            <td colspan="2">&nbsp;</td>
            
         </tr>
         <tr> 
            <th><b>품번</b></th>
            <td>${goodsVO.num }</td>
         </tr>
         <tr>
            <th><b>품명</b></th>
            <td>${goodsVO.item }</td>
         </tr>
         <tr>
            <th><b>가격</b></th>
            <td>${goodsVO.price } 원</td>
         </tr>
         <form:form class="ui form" action="cart" commandName="Goods" method="Post"
         onsubmit="confirm('정말 장바구니에 담으시겠습니까?')">
         <tr>
            <th><b>수량</b></th>
            <td><form:input path="count" style="border: 0; border-bottom: 1px solid black; text-align: right;"/> 개</td>
         </tr>
         <tr>
         	<td colspan="2">&nbsp;</td>
         </tr>
         <tr>
         	<td colspan="2">&nbsp;</td>
         </tr>
         <tr>
        	<c:if test="${not empty authInfo.id }">
         	<td colspan="2"><input type="submit" value="장바구니 담기" class="small ui red button" style="float: right;">
         	</c:if>
         	<c:if test="${empty authInfo.id }">
         	<td colspan="2"><input type="button" value="장바구니 담기" class="small ui red button" style="float: right;"
										onclick="alert('로그인을 해야합니다.')" />
         	</c:if>
         </tr>
         </form:form>
      </table> <hr>
  <br><br><br>
  <div style="text-align: center;">
      <table border="1">
         <c:forEach var="descript" items="${goodsVOarr }">
            <img src="<spring:url value='/images/goods/${descript }'/>" />
            <br>
         </c:forEach>
      </table>
   </div>
   
   
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>