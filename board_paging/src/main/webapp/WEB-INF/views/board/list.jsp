<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<div>
시작 버튼 : ${p.startPage }
마지막 버튼 : ${p.endPage }
</div>

<div class="jumbotron my-3">
	<h2>페이징 처리연습</h2>
</div>
<div class="container">
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td>${b.bno }</td>
				<td>
				<a href="${contextPath }/board/detail?bnumber=${b.bno }">${b.title }</a>
				</td>
				<td>${b.writer }</td>
				<td>${b.writeDate }</td>
			</tr>
		</c:forEach>
	</table>
	
  <ul class="pagination d-flex justify-content-center">
  	<c:if test="${p.prev }">
    <li class="page-item"><a class="page-link" href="?pageNum=${p.startPage-1 }">이전페이지</a></li>
    </c:if>
    
	<c:forEach begin="${p.startPage }" end="${p.endPage }" var="pageBtn">
    	<li class="page-item ${pageBtn==param.pageNum ? 'active' : '' }">
    	<a class="page-link" href="?pageNum=${pageBtn }">${pageBtn }</a></li>    
	</c:forEach>
	<c:if test="${p.next }">
 	   <li class="page-item"><a class="page-link" href="?pageNum=${p.endPage+1 }">다음페이지</a></li>
    </c:if>
  </ul>
</div>
현재페이지 ${param.pageNum }


</body>
</html>