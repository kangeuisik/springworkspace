<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h1>파일업로드</h1>
	<form action="${contextPath }/sample/upload" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"> <br>
		첨부파일 : <input type="file" name="attachFile">
	<button>GO</button>
	</form>

	<div>
		<img src="${contextPath }/imgDisplay?fileName=벵갈호랑이.png">
	</div>
</div>
<%@include file="../layout/footer.jsp" %>