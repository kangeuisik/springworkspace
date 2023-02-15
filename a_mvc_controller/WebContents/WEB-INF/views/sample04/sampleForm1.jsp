<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<form action="${contextPath }/sample04/list8">
		주소 : <input type="text" name="address"><br>
		나머지 주소 : <input type="text" name="address"><br>
		<button>전송</button>
	</form>

</div>
<%@include file="../layout/footer.jsp" %>