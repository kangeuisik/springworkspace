<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<form action="${contextPath }/sample04/list9">
		이름 : <input type="text" name="userName"><br>
		나이 : <input type="text" name="age"><br>
		이메일 : <input type="text" name="email"><br>
		<button>전송</button>
	</form>

</div>
<%@include file="../layout/footer.jsp" %>