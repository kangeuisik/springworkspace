<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<h1>게시글 상세</h1>
	<table class="table">
		<tr>
			<td>제목</td>
			<td>${b.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${b.content}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${b.writer}</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<c:if test="${empty b.fileName}">
					<b>첨부파일이 없습니다.</b>
				</c:if>
				<c:if test="${not empty b.fileName and b.fileType eq 'IMAGE'}">
					<img src="${contextPath}/imgDisplay?fileName=${b.bno}/${b.fileName}">
				</c:if>
				<c:if test="${not empty b.fileName and b.fileType eq 'OTHER'}">
					<a href="${contextPath}/download?fileName=${b.bno}/${b.fileName}">${b.fileName}</a> 
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="btn btn-danger delBoard">삭제</button>
				<a href="${contextPath}/board/modify?bno=${b.bno}" class="btn btn-inof">수정</a>
			</td>
		</tr>		
	</table>
</div>
<%@ include file="../layout/footer.jsp" %>

<script>
$(function(){
	$('.delBoard').click(function(){
		let form = $('<form/>')
		form.attr('method','post')
			.attr('action','${contextPath}/board/remove?bno=${b.bno}')
			.appendTo('body')
			.submit();
	})	
})
	
	

</script>


