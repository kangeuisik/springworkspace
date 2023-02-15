<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>글목록</h1>
	</div>
	<div class="card">
		<div class="card-header">
			<div>
				<span class="badge badge-info">번호 ${b.bno }</span>
				<span class="badge badge-info"> ${b.writer }</span>
				<span class="badge badge-info"> ${b.title }</span>
			</div>
		</div>
		<div class="card-body" style="min-height:350px">
			${b.content }	
		</div>
		<div class="card-footer">
			<button class="btn btn-warning modBoard">수정</button>
			<button class="btn btn-danger delBoard">삭제</button>
			<button class="btn btn-info">목록</button>
		</div>
	</div>
	<!-- 첨부파일 있을때 -->
	<c:if test="${not empty attachList }">
	<!-- 파일다운로드 -->
		<c:forEach items="${attachList }" var="attach">
		<div class="media border p-3 my-2">
			<div class="media-body d-flex justify-content-between">
				<div>
					<img src="${contextPath }/resources/images/fileicon.png" style="width:20px">
					${attach.fileName }
				</div>
				<div>
				 <a class="btn btn-info" href="${contextPath}/download?filePath=${attach.filePath}&fileName=${attach.fileName}">다운로드</a>
				</div>
			</div>
		</div>	 
		</c:forEach>
		<!-- 이미지 미리보기 -->
		<h3>이미지 미리보기</h3>
		<c:forEach items="${attachList }" var="attach">
			<c:if test="${attach.fileType eq 'IMAGE' }">
				<div class="media border p-3 my-2">
					<div class="media-body d-flex justify-content-between">
						<div>
							<img src="${contextPath }/imgDisplay?filePath=${attach.filePath}&fileName=${attach.fileName}" style="width:200px">
						</div> 
						<p>${attach.fileName }</p>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</c:if>
	<!-- 첨부파일 없을때 -->
	<c:if test="${empty attachList }">
		<div class="media border p-3 my-2">
			<div class="media-body">
			 <p>등록된 첨부파일이 없습니다.</p>
			</div>
		</div>
	</c:if>
</div>
<%@include file="../layout/footer.jsp" %>

<script>
$(function(){
	
	$('.delBoard').on('click',function(){
		$('<form/>').attr('method','post')
			.attr('action','${contextPath}/board/remove?bno=${b.bno}')
			.appendTo('body').submit();
	})
	
	$('.modBoard').on('click',function(){
		$('<form/>').attr('method','get')
		.attr('action','${contextPath}/board/modify')
		.append('<input type ="hidden" value="${b.bno}" name="bno">')
		.appendTo('body').submit();
})
	
})//function
</script>