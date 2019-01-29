<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/review/review.css">
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
<div class="review">
<h3 class="ui header" style="color: red; text-align: center;">F A Q</h3><br>
	<a class="small ui yellow button" href="<c:url value="/inquiry/list"/>" style="float: right;">문의하기</a>
	<br>
	<br>
			<table class="ui celled red table" style="font-size: 15px;">
			<thead>
				<tr>
					<th>Q. 품절 상품을 구입하고 싶어요.</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>A. 품절된 상품이나 상품 재고가 없어 상품을 선택할 수 없는 경우에는 현재는 구매가
						불가능하오나, 쇼핑몰에서 재고가 다시 확보될 경우 다시 판매될 수 있습니다.
						단, 품절 상품의 정확한 재 입고 시점을 안내해드리기 어려운 점 양해 부탁 드립니다.<br>
						자세한 사항을 원하시면 문의하여 주시기 바랍니다.<br>&nbsp;
					</td>
				</tr>
			</tbody>
			
			<thead>
				<tr>
					<th>Q. 상품 AS는 어떻게 받나요?</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>A. 당사 쇼핑몰은 엄격한 품질 검사를 통하여 제품의 안정성을 입증 받은 제품만 고객님들께 판매를 합니다.<br>
						그러나 일부 제품의 경우 고장이 발생하여 A/S를 받아야 할 경우도 있습니다.
						구입하신 제품은 고객 지원센터를 통하여 무상 A/S를 받으실 수 있습니다.<br>
						(일반적인 무상보증 기간은 1년이며, 고객님의 과실에 의한 고장은 유상 처리됩니다.)<br>&nbsp;
					</td>
				</tr>
			</tbody>
			
			<thead>
				<tr>
					<th>Q. 구입한 상품의 반품 후 환불은 어떻게 받나요?</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>A. 신용카드로 결제하신 고객님의 경우는 주문상품이 회수된 후에 즉시 카드 승인을 취소해 드리며, 무통장 입금의 경우 반품 후 다음날 고객님의 계좌로 송금하여 드립니다.<br>
						(배송완료 후 7일이 경과하거나, 제품이 개봉 또는 설치된 경우에는 취소 및 교환/반품이 불가하오니 참고하시기 바랍니다.)<br>&nbsp;
					</td>
				</tr>
			</tbody>
			
			<thead>
				<tr>
					<th>Q. 세금계산서를 발급받으려면?</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>A. [주문자성함],[주문번호],[주문금액],[연락처],[세금계산서를 받으실 이메일 주소]를 적어서, 팩스 또는 이메일로 보내시면 전자세금계산서를 이메일로 발송해 드립니다.<br>
						세금계산서 신청은 주문 후 익월 4일까지 신청 가능합니다.<br>
						(카드결제시에는 별도의 세금계산서는 발행되지 않으며, 카드전표가 그 역할을 대신하므로 카드전표를 출력하셔서 사용하시면 됩니다.​)<br>&nbsp;
					</td>
				</tr>
			</tbody>
			</table>
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>