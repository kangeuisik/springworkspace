<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h3>모든 쿠키 확인</h3>
	<div>
		${cookie.spring.name } : ${cookie.spring.value } 
		${cookie.jsp.name } : ${cookie.jsp.value }
	</div>
	
	<div>
		<a href="${contextPath }/sample08/delAllCookies">모든쿠키삭제</a>
	</div>
	<form action="${contextPath }/sample08/delCookies">
		삭제할 쿠키 : <input type="text" name="name">
		<button>삭제</button>
	</form>

</div>
<%@include file="../layout/footer.jsp" %>