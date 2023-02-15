<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp" %>
<div class="container">
	<h1>메인</h1>
	<div>
		<img alt="벵갈호랑이" src="${contextPath }/resources/images/벵갈호랑이.png">
	</div>
	<div>
		<c:if test="${not empty result }">
			${result }번삭제함
		</c:if>
	</div>
</div>
<%@include file="layout/footer.jsp" %>