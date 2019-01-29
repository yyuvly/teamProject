<%@page import="domain.CartItemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/goods/cart.css">
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
<div class="cart">
<h3 class="ui header" style="color: red; text-align: center;">c a r t</h3><br>
   <form name="pay" action="<c:url value="/orders/item" />" method="POST">
      <table class="ui celled small red table" style="text-align: center;">
         <tr>
            <th>이미지</th>
            <th>상품명</th>
            <th>판매가</th>
            <th>수량</th>
            <th>삭제</th>
         </tr>
         <c:if test="${empty cartItems}">
         <tr>
            <td colspan ="5"><br></br>장바구니가 비었습니다<br></br><br></td>
         </tr>
         
         </c:if >
         <c:forEach var="cartItem" items="${cartItems}" varStatus="loop">
            <tr>
               <td><img
                  src="<spring:url value='/images/goods/${cartItem.value.img}'/>"
                  width="100" height="100" /></td>
               <td>${cartItem.value.item}</td>
               <td>${cartItem.value.price * cookie[cartItem.key].value }</td>
               <td>${cookie[cartItem.key].value}</td>
               <td><a
                  href="<c:url value="/goods/cart/delete/${cartItem.value.num}"/>"><b>삭제</b></a></td>
            </tr>
         </c:forEach>
      </table>
      <br></br><br></br>
      
      <table class="ui celled table">
         <tr>
            <td class="th" style="text-align: center;"><b>결제 금액</b></td>
            <td style="text-align: right;">총 <b>${sessionScope.total}</b> 원</td>
         </tr>
      </table>
      <table class="ui celled table" style="text-align: center;">
         <tr>
            <td class="th"><b>결제 방식</b></td>
            <td style="text-align: center;">
            <div class="ui form">
            <div class="inline fields" id="payment">
               <div class="field">
                  <div class="ui radio checkbox">
                     <input type="radio" name="payment" value="true"
                        required="required"> <label style="padding-right:50px;">계좌이체</label>
                  </div>
               </div><br> <br>
               <div class="field">
                  <div class="ui radio checkbox" style="text-align: center;">
                     <input type="radio" name="payment" value="false"
                        required="required"> <label>신용카드</label>
                  </div>
               </div>
            </div></div></td>
         </tr>
      </table>
      <br>
      <input class="small ui red button" type="submit" style="float: right;" value="결제하기">
   </form>
   </div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>



