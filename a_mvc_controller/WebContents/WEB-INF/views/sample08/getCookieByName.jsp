<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h3>이름으로 쿠키 확인</h3>
	<div>
		${param.name == 'spring'  ? cookie.spring.value : '' }<br> 
		${param.name == 'jsp' ? cookie.jsp.value : '' }
	</div>

</div>
<%@include file="../layout/footer.jsp" %>