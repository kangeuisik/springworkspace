<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
<h1>hi~~~~~~~~~</h1>
<form action="${pageContext.request.contextPath }/result" method="post">
<input type="text" name="userName">
<button>go</button>

</form>
</body>
</html>