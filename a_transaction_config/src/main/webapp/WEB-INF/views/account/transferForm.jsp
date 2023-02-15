<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h1>포인트 보내기</h1>
		<form action="${contextPath }/account/transfer" method="post">
			<div>
				<h3>보내는 사람</h3>
				이름 : <input type="text" name="fromMemberName" value="${dto.fromMemberName }"><br>
				계좌 : <input type="text" name="fromAccount"value="${dto.fromAccount }"><br>
			</div>
			<div>
				<h3>보내는 사람</h3>
				이름 : <input type="text" name="toMemberName" value="${dto.toMemberName }"><br>
				계좌 : <input type="text" name="toAccount" value="${dto.toAccount }">
			</div>
			<div>
				보낼 포인트 : <input type="text" name="amount" value="${dto.amount }"> 
			</div>
			<button>전송</button>
		</form>
		<c:if test="${not empty error }">
			<p><b style="color: red;">${error }</b></p>
		</c:if>
	
</div>
<%@include file="../layout/footer.jsp" %>