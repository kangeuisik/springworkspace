<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h1>게시물 관리</h1>
	
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>
				<button class="btn btn-primary selDel">선택삭제</button>
			</th>
		</tr>
		<c:if test="${empty boardList }">
			<tr>
				<td colspan="4"><b>게시물이 존재하지 않습니다</b></td>
			</tr>
		</c:if>
		<c:if test="${not empty boardList }">
			<c:forEach items="${boardList }" var="b">
			<tr>
				<td>${b.bno }</td>
				<td>${b.title }</td>
				<td>${b.writer }</td>
				<td class="col-2">
					<input type="checkbox" class="form-control bno_ckbox" value="${b.bno }">
				</td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
</div>
<%@include file="../layout/footer.jsp" %>

<script>
$(function(){
	//밖에 set 집합 만들어줌
	let bnoSet = new Set();
	
	$('.bno_ckbox').on('change',function(){
		let bno = $(this).val();//체크이벤트의 밸류값
		let isChecked = $(this).prop('checked') //true 반환 checked가 안되있음 false
		if(isChecked){
			console.log(bno+"번 쳌");		//체크하면 set집합에 넣고
			bnoSet.add(bno);
		}else{
			console.log(bno+"번 체크해제");	//체크해제 하면 set에서 빼버림
			bnoSet.delete(bno);
		}
		console.log(bnoSet);
	})	
	$('.selDel').on('click',function(){
		console.log(bnoSet.size+'삭제'); //set에 담긴 배열
		if(bnoSet.size<=0){
			alert('삭제할 게시물을 선택하시오');
			return;
		}
		let delForm = $('<form/>')
		//set을 배열로 그리고 문자열로 변환해야함 
		let bnoListStr = Array.from(bnoSet).join(); //array.from()배열로변경.join문자열로 변경 
		delForm.attr('method','post') // get방식으로 해당 페이지로 보내줌
			.attr('action','${contextPath}/board/delSelectedBoard?bnoList='+bnoListStr)
			.appendTo('body')
			.submit();
		
	})//selDel	
});//
</script>