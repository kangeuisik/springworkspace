<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<input type="hidden" value="${category }" class="category">
<div class="container">
	<div class="jumbotron">
		<h1>게시물 목록</h1>
	</div>
		<div class="row">
			<div class="col-3">
				<ul class="list-group">
					<li class="list-group-item">
						<a href="${contextPath }/board/list">전체</a>
					</li>
					<li class="list-group-item">
						<a href="${contextPath }/board/list/notice">공지사항</a>
					</li>
					<li class="list-group-item">
						<a href="${contextPath }/board/list/free">자유게시판</a>
					</li>
				</ul>
			</div>
			<div class="col-9">
				<div class="my-3">
					<form class="form-inline searchForm" >
						<select class="category form-control mr-2">
							<option value="">-----전체-----</option>
							<option value="notice" ${category == 'notice' ? 'selected':''}>공지사항</option>
							<option value="free" ${category == 'free' ? 'selected':''}>자유게시판</option>			
						</select>
						<select name="type" class="form-control mr-2">
							<option value="T" ${cri.type == 'T' ? 'selected':''}>제목</option>
							<option value="C" ${cri.type == 'C' ? 'selected':''}>내용</option>
							<option value="W" ${cri.type == 'W' ? 'selected':''}>작성자</option>			
						</select>
						<div class="form-group mr-2">
							<input type="search" class="form-control" name="keyword" value="${cri.keyword}">
						</div>
						<div class="form-group mr-2">
							<button type="button" class="btn btn-primary">검색</button>
						</div>
						<div class="form-group">
							<a href="${contextPath}/board/list"  class="btn btn-info">새로고침</a>
						</div>
					</form>		
				</div>
				<table class="table">
					<tr>
						<th>번호</th>
						<th>분류</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
					<c:choose>
						<c:when test="${empty list }">
							<tr><td colspan="5"><b>등록된 게시물이 없습니다.</b></td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${list }" var="b">
								<tr>
									<td>${b.bno }</td>
									<td>${b.category }</td>
									<td>${b.title }</td>
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
						<a class="page-link" href="${p.startPage-1}">이전</a>
					</li>
				</c:if>
				<c:forEach begin="${p.startPage }" end="${p.endPage}" var="pageNum">
					<li class="page-item ${cri.page == pageNum ? 'active':''}">
						<a class="page-link" href="${pageNum}">${pageNum}</a>
					</li>		
				</c:forEach>
				<c:if test="${p.next}">
					<li class="page-item">
						<a class="page-link" href="${p.endPage+1 }">다음</a>
					</li>		
				</c:if>
			</ul>
		</div>
	</div>

		
</div>
<%@include file="../layout/footer.jsp" %>