<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">

	<div>
		<ul>
			<li>이름 : 손흥민, 휴대폰번호 : 010-1111-2222</li>
			<li>이름 : 김민재, 휴대폰번호 : 010-1451-7589</li>
			<li>이름 : 황희찬, 휴대폰번호 : 010-1123-2897</li>
		</ul>
	</div>
		<div>
			<button class="addForm">폼추가</button>
			<button class="delForm">폼삭제</button>
		</div>
	<form method="post" class="contactForm">
		<div class="contactDiv">
			이     름 : <input type="text" name="contactList[0].name" class="name"><br> 
			휴대폰 번호 : <input type="text" name="contactList[0].phoneNumber" class="phone">
		</div>
		<button>전송</button>
	</form>

</div>
<%@include file="../layout/footer.jsp" %>

<script>

$(function(){
	let numberDiv = 1;
	
	$('.addForm').on('click',function(){
		if(numberDiv>=10){
			alert('10개 이상 추가할 수 없습니다.');
			return;
		}
		let contactDiv = $('.contactDiv').eq(0).clone();
		let nameInput = contactDiv.find('.name');
		let phoneInput = contactDiv.find('.phone');
		let n = nameInput.attr('name').replace('0',numberDiv);
		let p = phoneInput.attr('name').replace('0',numberDiv);
		nameInput.attr('name',n);
		phoneInput.attr('name',p)
		$('.contactForm').append(contactDiv)
		numberDiv++;
	});
	
	$('.delForm').on('click',function(){
		if(numberDiv<=1){
			alert('삭제할 수 없습니다.');
			return;
		}
		$('.contactDiv').eq(numberDiv-1).remove();
		numberDiv--;
	})
});
</script>