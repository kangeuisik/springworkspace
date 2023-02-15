<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>게시물 등록</h1>
	</div>
	<form action="${contextPath }/board/list2">
		<select name="type">
			<!-- cri.type 제목이면 선택하고 아니면 빈문자 반환 -->
			<option value="T" ${cri.type eq 'T' ? 'selected':'' }>제목</option>
			<option value="C" ${cri.type eq 'C' ? 'selected':'' }>내용</option>
			<option value="W" ${cri.type eq 'W' ? 'selected':'' }>작성자</option>
		</select>
		<input type="text" name="keyword" value="${cri.keyword }">
		<button>검색</button>
	</form>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bno }</td>
				<td>
					<a href="${contextPath }/board/detail?bno=${b.bno}">${b.title }</a>
				</td>
				<td>${b.writer }</td>
				<td>
					<fmt:formatDate value="${b.writeDate }" pattern="yyyy년MM월dd일 hh:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="../layout/footer.jsp" %>