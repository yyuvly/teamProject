<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
													<!-- 에러를 알려주기 위해 -->
<%-- <%
	String name = (String) session.getAttribute("name");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inquiry/inquiry.css">
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
<div class="inquiry">
<form:form class="ui form" commandName="inquiryVO" method="POST" >
<h3 class="ui header" style="color: red; text-align: center;">r e p l y</h3><br>
	<table class="ui celled table">
		<tr>
			<td class="th" align="center"><b>작성자</b></td>
			<td>${member.name}<form:errors path="name" /></td>
			<td class="th"><b>타입</b></td>
			<td>
				<div class="ui radio checkbox">
					<form:radiobutton path="type" value="호텔" required="required" />
					<label>호텔&nbsp;&nbsp;</label>
				</div>
				<div class="ui radio checkbox">
					<form:radiobutton path="type" value="물품" required="required" />
					<label>물품</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="th"><form:label path="item"><b>제목</b></form:label></td>
			<td colspan="3"><form:input path="item" required="required" style="border: none"/>
						<form:errors path="item"/></td>
		</tr>
		<tr>
			<td class="th"><form:label path="content"><b>내용</b></form:label></td>
			<td colspan="3"><form:textarea path="content" required="required" style="border: none; resize: none;"/>
							<form:errors path="content"/></td>
		</tr>
	
	
		<%-- <tr>
			<th><form:label path="name">작성자</form:label></th>
			<td>${member.name}
				<form:errors path="name"/></td>
		</tr>
 		<tr>
			<th><form:label path="type">타입</form:label></th>
			<td>${inquiryVO.type}
				<form:errors path="type"/></td>
		</tr>
		<tr>
			<th><form:label path="item">제목</form:label></th>
			<td>
			<form:input path="item" value="[RE] "/>
			<form:errors path="item"/></td>
		</tr>
		<tr>
			<th><form:label path="content">내용</form:label></th>
			<td><form:textarea path="content" required="required"/>
				<form:errors path="content"/></td>
		</tr> --%>
	</table>
	<br>
	<div>
		<input type="hidden" name="rnum" value="${inquiryVO.rnum}">
		<input type="hidden" name="rstep" value="${inquiryVO.rstep}">
		<input type="hidden" name="rlevel" value="${inquiryVO.rlevel}">
		
		<a class="small ui yellow button" href="<c:url value="/inquiry/list"/>" style="float: right;">목록</a>
		<button class="small ui red button" type="submit" style="float: right;">등록</button>
	</div>
</form:form>

<div class="push"></div>
<jsp:include page="/WEB-INF/view/bottom.jsp" flush="false" />
</div>
</div>
</body>
</html>



