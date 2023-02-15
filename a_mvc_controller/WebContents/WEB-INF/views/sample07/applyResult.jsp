<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">


 	이름 : ${applyForm.name }<br>
 	이메일 : ${applyForm.email }<br>
 	<c:forEach items="${applyForm.universityList }" var="u" varStatus="status">
 		<ul>
 			<li>${status.count } 지망</li>
 			<li>학교 : ${u.name }, 전공 : ${u.major }</li>
 		</ul>
	</c:forEach>
</div>
<%@include file="../layout/footer.jsp" %>