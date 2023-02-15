<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">


 	이름 : ${studentVO.name }<br>
 	이메일 : ${studentVO.email }<br>
 	영어 : ${studentVO.reportCard.eng }<br>
 	수학 : ${studentVO.reportCard.math }<br>
 	과학 : ${studentVO.reportCard.science }<br>

</div>
<%@include file="../layout/footer.jsp" %>