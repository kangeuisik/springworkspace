<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<title>Insert title here</title>
</head>
<body>
	<button class="btn1">데이터불러오기</button>
	<div>
		<input type="text" class="number"><br>
		<input type="text" class="title">
		<button class="btn2">전송</button>
	</div>
</body>
<script>

	$('.btn1').click(function(){
		$.ajax({
			type : 'get',
			url : '${contextPath}/sample/sampleMap',
			contentType : 'application/json;charset=utf-8',
			success : function(sampleMap){
				console.log(sampleMap.bean1);
			},
			error : function(){
				alert('틀림')
			}
			
		});
	})
	
	$('.btn2').click(function(){
		let bean = {
			number : $('.number').val(),
			title : $('.title').val()
		};
		 console.log(bean);
		$.ajax({
			type : 'post',
			url : '${contextPath}/sample/send',
			contetnType : 'application/json;charset=utf-8',
			data : JSON.stringify(bean), 
			success : function(result){
				console.log(result);
			},
			error : function(){
				alert('틀림')
			}	
		})
	})
</script>
</html>