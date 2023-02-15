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
	<form action="${contextPath }/member/join" method="post">
		<spring:hasBindErrors name="memberDTO"/><!-- name속성 : 커맨드객체이름 -->
		<div class="form-group">
			<label for="memberName">이름</label>
			<input type="text" class="form-control" id="memberName" name="memberName" value="${ memberDTO.memberName}">
			<form:errors path="memberDTO.memberName" element="div" class="input_errors" />
		</div>
		<div class="form-group">
			<label for="memberId">아이디</label>
			<input type="text" class="form-control" id="memberId" name="memberId" value="${ memberDTO.memberId}">
			<form:errors path="memberDTO.memberId" element="div" class="input_errors" />
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="text" class="form-control" id="password" name="password" value="${ memberDTO.password}">
			<form:errors path="memberDTO.password" element="div" class="input_errors"/>
		</div>
		<div class="form-group">
			<label for="confirmPassword">비밀번호 확인</label>
			<input type="text" class="form-control" id="confirmPassword" name="confirmPassword" value="${ memberDTO.confirmPassword}">
			<form:errors path="memberDTO.confirmPassword" element="div" class="input_errors" />
		</div>
		<div class="form-group">
			<label for="email">이메일</label>
			<input type="text" class="form-control" id="email" name="email" value="${ memberDTO.email}">
			<form:errors path="memberDTO.email" element="div" class="input_errors" />
		</div>
		<div class="form-group">
			<label for="phoneNumber">폰번호</label>
			<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${ memberDTO.phoneNumber}" placeholder="하이픈 '-'없이 입력">
			<form:errors path="memberDTO.phoneNumber" element="div" class="input_errors" />
		</div>
		<button class="btn btn-info">Go!</button>
	</form>
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