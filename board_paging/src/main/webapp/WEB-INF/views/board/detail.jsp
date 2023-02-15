<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<table class="table">
		<tr>
			<th>제목</th>
			<td colspan="3"">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${board.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
			<th>작성시간</th>
			<td>${board.writeDate }</td>
		</tr>
		<tr>
			<td colspan="4">
				<button>수정</button>
				<button>삭제</button>
				<button>목록</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>