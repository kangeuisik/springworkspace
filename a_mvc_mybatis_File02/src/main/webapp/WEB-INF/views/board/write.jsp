<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>글쓰기(첨부파일 여러개)</h1>
	</div>
	<form action="${contextPath }/board/write" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title" class="form-control" placeholder="제목">
		내용 : <textarea rows="10" name="content" class="form-control"></textarea>
		작성자 : <input type="text" name="writer" class="form-control" placeholder="작성자">
		<div class="fileForm">
			<div>
				<button type="button" class="btn btn-primary add">첨부파일 추가</button>
				<button type="button" class="btn btn-danger del">첨부파일 삭제</button>
			</div>
	첨부파일 : <input type="file" name="attachFile" class="form-control attachFile">
			
		</div>
		<button class="btn btn-info mt-3">Go!</button>
	</form>
</div>
<%@include file="../layout/footer.jsp" %>
<script>
$(function(){
	 //폼추가
	 let formCount = 1;
	$('.fileForm .add').on('click',function(){
		if(formCount>=5){
			alert('5개이상 추가할수 없어')
			return;
		}
		
		let fileFormTag = $('.fileForm .attachFile').eq(0).clone().val('');
		$('.fileForm').append(fileFormTag);
		formCount++;
	})
	
	$('.fileForm .del').on('click',function(){
		if(formCount<=1){
			alert('에이 하나는 있어야지')
			return;
		}
		$('.fileForm .attachFile').eq(formCount-1).remove();
		formCount--;
	})
	
})
	
</script>