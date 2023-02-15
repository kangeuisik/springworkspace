<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>게시물 목록</h1>
	</div>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
			<c:forEach items="${list}" var="b">
				<tr>
					<td>${b.bno }</td>
					<td>
						<a href="${contextPath}/board/detail?bno=${b.bno}&page=${cri.page}">
							${b.title}						
						</a>
					</td>
					<td>${b.writer }</td>
					<td>${b.writeDate }</td>				
				</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<ul class="pagination">
		<c:if test="${p.prev}">
		<li class="page-item">
			<a class="page-link" href="?page=${p.startPage-1}">Previous</a>
		</li>
		</c:if>
		<c:forEach begin="${p.startPage}" end="${p.endPage }" var="pageNum">		
			<li class="page-item ${cri.page == pageNum ? 'active':''}">
				<a class="page-link" href="?page=${pageNum}">${pageNum}</a>
			</li>
		</c:forEach>
		<c:if test="${p.next}">
		<li class="page-item">
			<a class="page-link" href="?page=${p.endPage+1}">Next</a>
			</li>
		</c:if>
	</ul>	
	
</div>
<%@ include file="../layout/footer.jsp" %>


