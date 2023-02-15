<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
경로변수 : ${cid }
<div class="container">
	<div class="jumbotron">
		<h1>글쓰기</h1>
	</div>
	${cateList }
	<form action="${contextPath }/board/write" method="post">
		<table class="table">
			<tr>
				<td class="col-2">게시판 분류</td>
				<td>
					<select name="category.cid" class="form-control">
						<c:forEach items="${cateList }" var="c">
							<option value="${c.cid }">${c.cname }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" class="form-control" name="title"> </td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" class="form-control" name="content"></textarea> </td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" class="form-control" name="writer"> </td>
			</tr>
		</table>
		<button class="btn btn-primary">글쓰기</button>
	</form>
</div>
<%@include file="../layout/footer.jsp" %>