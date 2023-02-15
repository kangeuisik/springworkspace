console.log('detail.js');

$(function(){
	let pageForm = $('<form/>')
	let pageTag = $('[name="page"]')
	// let page = $('[name="page"]').val()
	
	$('.list').on('click',function(){
		// location.href = `${contextPath}/board/list?page=${page}`;
		pageForm.attr('method','get')
			.attr('action',`${contextPath}/board/list`)
			.append(pageTag)
			.appendTo('body')
			.submit()
	})
})