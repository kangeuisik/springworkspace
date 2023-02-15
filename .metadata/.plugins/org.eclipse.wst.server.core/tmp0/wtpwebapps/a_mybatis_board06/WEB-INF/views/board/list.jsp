<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<input type="hidden" name="page" class="page" value="${cri.page }">
<div class="container">
	 <div class="jumbotron">
	 	<h1>게시물 목록</h1>
	 	페이지 번호 : ${cri.page }
	 </div>
	 <div class="my-3">
	 	<form class="form-inline" action="${contextPath }/board/list">
	 		<select name="type" class="form-control mr-2">
	 			<option value="T" ${cri.type == 'T' ? 'selected':''}>제목</option>
	 			<option value="C" ${cri.type == 'C' ? 'selected':''}>내용</option>
	 			<option value="W" ${cri.type == 'W' ? 'selected':''}>작성자</option>
	 		</select>
	 		<div class="form-group mr-2">
	 			<input type="search" class="form-control" name="keyword" value="${cri.keyword }">
	 		</div>
	 		<div class="form-group mr-2">
	 			<button class="btn btn-primary">검색</button>
	 		</div>
	 		<div class="form-group mr-2">
				 <a href="${contextPath }/board/list" class="btn btn-info">새로고침</a>
	 		</div>
	 	</form>
	 </div>
	 
	 <table class="table">
	 	<tr>
	 		<th>번호</th>
	 		<th>제목</th>
	 		<th>작성자</th>
	 		<th>작성일</th>
	 	</tr>
	 	<c:choose>
	 		<c:when test="${empty list }">
	 			<tr>
	 				<td colspan="4"><b>게시물이 존재하지 않습니다</b></td>
	 			</tr>
	 		</c:when>
	 		<c:otherwise>
	 			<c:forEach items="${list }" var="b">
		 			<tr>
		 				<td>${b.bno }</td>
		 				<td>
		 					<a href="${b.bno}" class="goDetail">${b.title }</a>
		 				</td>
		 				<td>${b.writer }</td>
		 				<td>${b.writeDate }</td>
		 			</tr>
	 			</c:forEach>
	 		</c:otherwise>
	 	</c:choose>
	 </table>
	 <ul class="pagination container">
		 <c:if test="${p.prev }">
		 	<li class="page-item">
		 		<a href="${p.startPage-1}" class="page-link">이전</a>
		 	</li>
	 	</c:if>
	 	<c:forEach begin="${p.startPage }" end="${p.endPage }" var="pageNum">
		 	<li class="page-item ${cri.page ==pageNum ? 'active':''}">
		 		<a href="=${pageNum }" class="page-link">${pageNum }</a>
		 	</li>
	 	</c:forEach>
	 	<c:if test="${p.next }">
		 	<li class="page-item">
		 		<a href="${p.endPage+1}" class="page-link">다음</a>
		 	</li>
	 	</c:if>	
	 </ul>

</div>
<%@include file="../layout/footer.jsp" %>