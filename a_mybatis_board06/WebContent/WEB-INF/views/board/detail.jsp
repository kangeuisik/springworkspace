<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	 <div class="jumbotron">
	 	<h1>게시물 상세보기</h1>
	 	페이지 번호 : ${param.page }
	 </div>

	<div>
		번호 : ${b.bno } 
	</div>
	<div>
		제목 : ${b.title } 
	</div>
	<div>
		내용 : ${b.content } 
	</div>
	<div>
		작성자 : ${b.writer }
	</div>
	<div>
		작성일 : ${b.writeDate } 
	</div>
	<div>
		
		<button class="#">수정</button> 
		<button class="#">삭제</button>
		<button class="list">목록</button>
	</div>

</div>
<%@include file="../layout/footer.jsp" %>