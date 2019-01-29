<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
													<!-- 에러를 알려주기 위해 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호텔 예약</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hotel/reserve.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="/css/semantic/semantic.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script>
$(function() {
	$("#datepicker1").datepicker({
		dateFormat:'yy-mm-dd'
	});
	$("#datepicker2").datepicker({
		dateFormat:'yy-mm-dd'
	});
});
$(function() {
	$("#spinner").spinner({
		min:1,
		max:10,
		step:1
	});
});
</script> 
</head>
<body>
<div class="wrap">
<jsp:include page="/WEB-INF/view/top.jsp" flush="false" />

<div class="reserve">
<h3 class="ui header" style="color: red; text-align: center;">h o t e l</h3><br>
	<form:form class="ui form" action="confirm" commandName="formData">
			<div class="field">
				<label>댕댕이의 이름은 무엇인가요?</label>
				<form:input path="a_name" placeholder="name" required="required" />
			</div>
			<div class="field">
				<label>댕댕이의 나이는 몇살인가요?</label>
				<form:input path="a_age" placeholder="age(1~10)" required="required"
					value="" />
			</div>
			<div class="inline fields">
				<label for="a_gender">댕댕이의 성별은 무엇인가요?</label>
				<div class="field">
					<div class="ui radio checkbox">
						<form:radiobutton path="a_gender" value="여" required="required" />
						<label>여</label>
					</div>
				</div>
				<br>
				<br>
				<div class="field">
					<div class="ui radio checkbox">
						<form:radiobutton path="a_gender" value="남" required="required" />
						<label>남</label>
					</div>
				</div>
			</div>
			<div class="field">
				<label>호텔을 이용할 댕댕이는 몇마리인가요?</label>
				<form:input path="a_cnt" placeholder="count(1~10)"
					required="required" />
				<!-- <input type="number" min="1" max="10" path="a_cnt" placeholder="count(1~10)" required="required"/> -->
			</div>
			<div class="field">
				<label>check in</label>
				<form:input path="checkin" id="datepicker1" required="required" />
			</div>
			<div class="field">
				<label>check out</label>
				<form:input path="checkout" id="datepicker2" required="required" />
			</div>
			<button class="small ui red button" type="submit" style="float: right;">확인</button>
	</form:form>
</div>
<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</body>
</html>













