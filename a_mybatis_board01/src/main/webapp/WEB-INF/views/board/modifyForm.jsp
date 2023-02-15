<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>게시물 수정</h1>
	</div>
	<form action="${contextPath }/board/modify" method="post">
	<div>
		<input type="hidden" name="bno" value="${board.bno }">
		번호 : ${board.bno } 
	</div>
	<div>	
		제목 : <input type="text" name="title" value="${board.title }">
	</div>
	<div>
		내용 : <textarea rows="10" name="content" cols="">${board.content }</textarea>
	</div>
	<div>
		작성자 : ${board.writer }
	</div>
	<div>
		작성일 : ${board.writeDate }
	</div>
	<div>
		<button >수정</button>
		<button type="button" class="">취소</button>
	</div>
	</form>
</div>
<script>
$(function(){
	$('.modifyForm').on('click',function(){
		let bno = $('[name="bno"]')
		let form = $("<form/>")
		form.attr("action","${contextPath}/board/modifyForm")
			.attr("metod","get")
			.append(bno).appendTo('body').submit();
	})
})
</script>

<%@include file="../layout/footer.jsp" %>