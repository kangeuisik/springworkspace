<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../layout/header.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>회원가입</h1>
	</div>
	<!-- 
		이름, 아이디 비번, 비번확인 ,이메일, 번호
	 -->

</div>
<%@include file="../layout/footer.jsp" %>

<style>
.input_errors{
	font-size: 13px;
	font-weight: bold;
	color: red;
}
.error_on{
	border-color:red;
}
</style>

<script>
$(function(){
	let errorForm = $('.input_errors');
	console.log(errorForm.length);
	if(errorForm.length>0){
		errorForm.prev().addClass('error_on');
	}
	
})//function
</script>