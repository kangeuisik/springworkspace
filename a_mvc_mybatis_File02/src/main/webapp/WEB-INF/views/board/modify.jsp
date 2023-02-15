<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>수정..</h1>
	</div>
	<form class="modBoardForm" action="${contextPath }/board/modify" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bno" value="${b.bno }">
		제목 : <input type="text" name="title" class="form-control" placeholder="제목" value="${b.title }">
		내용 : <textarea rows="10" name="content" class="form-control">${b.content }</textarea>
		작성자 : <input type="text" name="writer" class="form-control" placeholder="작성자" value="${b.writer }" readonly="readonly">
		<div class="fileForm">
			<div>
				<button type="button" class="btn btn-primary add">첨부파일 추가</button>
				<button type="button" class="btn btn-danger del">첨부파일 삭제</button>
			</div>
	첨부파일 : <input type="file" name="attachFile" class="form-control attachFile">
			
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
					 	<label for="delCheck">삭제 : </label>
					 	<input type="checkbox" class="form-control delCheck" value="${attach.attachNo }" id="delCheck">
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
		<button class="btn btn-info modBoardProc">수정완료</button>
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
	let setDel = new Set();
	$('.delCheck').on('change',function(){
		let checkStatus = $(this).prop('checked');
		if(checkStatus){//체크상태
			setDel.add($(this).val());
		}else{//언쳌
			setDel.delete($(this).val());
		}
		console.log(setDel);
	})
	//수정처리
	$('.modBoardProc').on('click',function(e){
		e.preventDefault();//폼버튼의 기본동작 막기
		let delFileList = Array.from(setDel).join();
		$('.modBoardForm').append('<input type="hidden" name="delFileList" value="'+delFileList+'">')
		$('.modBoardForm').submit();
	})
	
})
	
</script>