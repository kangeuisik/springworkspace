<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>

<form action="${pageContext.request.contextPath}/member/register" method="post">
	아이디 : <input type="text" name="userId">
	비밀번호 : <input type="text" name="userPwd">
	<button>회원가입</button>
</form>

</body>
</html>