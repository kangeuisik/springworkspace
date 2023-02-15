<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../layout/header.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>글쓰기</h1>
	</div>
	<!-- 
		제목 내용 작성자 
	 -->
	<div class="container">
		<form action="${contextPath }/board/write" method="post">
		<div>
			<spring:hasBindErrors name="boardDTO"/><!-- name속성 : 커맨드객체이름 -->
			제목 : <input type="text" name="title" class="form-control" value="${boardDTO.title }">
			<form:errors path="boardDTO.title" element="div" class="input_errors" />
		</div>
		<div>
			<spring:hasBindErrors name="boardDTO"/>
			내용 : <input type="text" name="content" class="form-control" value="${boardDTO.content }">
			<form:errors path="boardDTO.content" element="div" class="input_errors" />
		</div>
				<div>
			<spring:hasBindErrors name="boardDTO"/>
			작성자 : <input type="text" name="writer" class="form-control" value="${boardDTO.writer }">
			<form:errors path="boardDTO.writer" element="div" class="input_errors" />
		</div>
			<button class="btn btn-info">go</button>
		</form>
	</div>

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
	let errorForm = $('.errors');
	console.log(errorForm.length);
	if(errorForm.length>0){
		errorForm.prev().addClass('error_on');
	}
	
})
</script>