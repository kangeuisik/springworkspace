<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="${contextPath}/resources/js/detail.js"></script>


<div class="container">
	<div class="jumbotron">
		<h1>게시물 상세</h1>
		페이지 번호 : ${param.page}
	</div>
	<div>
		번호 :${board.bno} 
	</div>
	<div>
		제목 : ${board.bno}
	</div>
	<div>
		내용 : ${board.title}
	</div>
	<div>
		작성자 : ${board.writer}
	</div>
	<div>
		작성일 : ${board.writeDate}
	</div>
	<div>
		<button>수정</button>
		<button>삭제</button>
		<button class="list">목록</button>
	</div>
	<input type="hidden" name="page" value="${param.page}">
</div>
<%@ include file="../layout/footer.jsp" %>


