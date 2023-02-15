<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h3>쿠키생성페이지</h3>
	<a href="${contextPath }/sample08/getCookie">생성된 모든 쿠키확인</a>
	<form action="${contextPath }/sample08/getCookieByName">
		<h1>이름으로 쿠키확인</h1>
		<input type="text" name="name">
		<button>확인</button>
	</form>
</div>
<%@include file="../layout/footer.jsp" %>