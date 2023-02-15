<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
	<h1>연락처</h1>
	
	<table class="table">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>연락처</th>
		</tr>
		<c:if test="${empty contactList }">
			<tr>
				<td colspan="3"><b>등록된 연락처가 없습니다</b></td>
			</tr>
		</c:if>
		<c:if test="${not empty contactList }">
			<c:forEach items="${contactList }" var="c">
				<tr>
					<td>${c.cno }</td>
					<td>${c.userName }</td>
					<td>${c.phoneNumber }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="d-flex justify-content-between my-3">
		<h3>연락처 추가</h3>
		<div>
			<button class="btn btn-info addContactLiBtn">폼추가</button>
			<button class="btn btn-danger delContactLiBtn">폼삭제</button>
		</div>
	</div>
	<form class="contactForm" action="${contextPath }/contact/addContact" method="post">
		<ul class="list-group">
			<li class="list-group-item text-center">
				<div class="form-group row">
					<label class="col-2">이름</label>
					<div class="col-10">
						<input type="text" class="form-control userName" name="contactList[0].userName">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2">휴대폰 번호</label>
					<div class="col-10">
						<input type="text" class="form-control phoneNumber" name="contactList[0].phoneNumber">
					</div>
				</div>
			</li>
		</ul>
		<button class="btn btn-primary">저장</button>
	</form>
</div>
<%@include file="../layout/footer.jsp" %>

<script>
$(function(){
	//삭제
	let liNumber = 1;
	
	$('.addContactLiBtn').on('click',function(){
		if(liNumber>=5){
			alert('더이상 추가할수 없습니다.');
			return;
		}
		let contactLi = $('.contactForm li').eq(0).clone(); // 하나만(eq) 복사(clone)
		contactLi.find('input').val(''); //input의 모든값 삭제
		let userNameInput = contactLi.find('.userName'); //input 선택
		let phoneNumberInput = contactLi.find('.phoneNumber');//input 선택
		let u = userNameInput.attr("name").replace('0',liNumber); //userName속성의 값을 바꿔 준다 
		let p = phoneNumberInput.attr("name").replace('0',liNumber); //phoneNumber속성의 값을 바꿔 준다
		userNameInput.attr("name",u); // 변경한 name속성 설정
		phoneNumberInput.attr("name",p);// 변경한 name속성 설정
		$('.contactForm ul').append(contactLi); //ul태그에 추가
		liNumber++; // 인덱스 번호 증가
	})//addContactLiBtn
	
	//삭제
	$('.delContactLiBtn').on('click',function(){
		if(liNumber<=1){//폼이 하나만 있을때 삭제할수 없음
			alert('더이상 삭제할수 없습니다.');
			return;
		} //인덱스와의 관계를 생각하고 해야함.
		$('.contactForm li').eq(liNumber-1).remove(); // 마지막 폼의 태그 삭제
		liNumber--;
	})
	//등록 눌렀을 시 데이터 전송
});//
</script>