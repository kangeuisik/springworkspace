console.log('detail.js');

$(function(){

	let typeVal = getSearchParam('type');
	let keywordVal = getSearchParam('keyword');

	
	$('.list').on('click',function(){
		let detailForm = $('<form>');
		detailForm.empty();
	 	detailForm.attr('method','get')
	 		.attr('action',`${contextPath}/board/list`)
	 		.append(getInputHiddenTag("page",getSearchParam('page')))
			if(typeVal !=null && keywordVal!=null){
			detailForm.append(getInputHiddenTag('type',typeVal))
	 			.append(getInputHiddenTag('keyword',keywordVal))
	 		}
	 		detailForm.appendTo('body')
	 		.submit();
	});
});