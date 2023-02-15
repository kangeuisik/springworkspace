<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h1>글쓰기</h1>
	<form action="${contextPath }/board/write" method="post" enctype="multipart/form-data">
		<input type="text" name="title" placeholder="제목" class="form-control"><br>
		<textarea rows="10" cols="" name="content" placeholder="내용" class="form-control"></textarea>
		<input type="text" name="writer" placeholder="작성자" class="form-control"><br>
		<input type="file" name="attachFile" class="form-control"><br>
		<button class="btn btn-primary">글쓰기</button>
	</form>
</div>
<%@include file="../layout/footer.jsp" %>