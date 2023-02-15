<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
경로변수 : ${cid }
<div class="container">
	<div class="jumbotron">
		<h1>리스트</h1>
	</div>
	<div class="row">
		<div class="col-3">
			<ul class="list-group">
			  <li class="list-group-item ${cid==c.cid ? 'list-group-item-primary':''}">
			  	<a href="${contextPath}/board/list">전체</a>
			  </li>
			  <c:forEach items="${cateList}" var="c">
			  <li class="list-group-item ${cid==c.cid ? 'list-group-item-primary':''}">
			  	<a href="${contextPath}/board/list/${c.cid}">${c.cname}</a>
			  </li>
			  </c:forEach>
			</ul>	
		</div>
		<div class="col-9">
			<table class="table">
				<tr>
					<th>번호</th>
					<th>분류</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				<c:forEach items="${list }" var="b">
				<tr>
					<td>${b.bno }</td>
					<td>${b.category.cname }</td>
					<td>${b.title }</td>
					<td>${b.writer }</td>
					<td>${b.writeDate }</td>
				</tr>
				</c:forEach>
			</table>	
			<a href="${contextPath }/board/write" class="btn btn-primary">글쓰기</a>
		</div>	
	</div>
	
</div>
<%@include file="../layout/footer.jsp" %>