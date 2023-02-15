console.log('list.js');

$(function(){
	
	let typeVal = getSearchParam('type');
	let keywordVal = getSearchParam('keyword');
	
	
	$('.pagination a').on('click',function(e){
		let pageForm = $('</form>');
		e.preventDefault();
		pageForm.empty();
	 	pageForm.attr('method','get')
	 		.attr('action',`${contextPath}/board/list`)
	 		.append(getInputHiddenTag('page',$(this).attr('href')))
	 		if(typeVal !=null && keywordVal!=null){
	 			pageForm.append(getInputHiddenTag('type',typeVal))
	 				.append(getInputHiddenTag('keyword',keywordVal))
	 		}
	 		pageForm.appendTo('body')
	 		.submit();
	});
	//상세 게시물로 이동
	$('.goDetail').on('click',function(e){
		e.preventDefault();
		let goDetailForm = $('<form/>');
		goDetailForm.empty();
		goDetailForm.attr('method','get')
			.attr('action',`${contextPath}/board/detail`)
			.append(getInputHiddenTag('bno',$(this).attr('href')))
			.append($('.page'))
			if(typeVal !=null && keywordVal!=null){
	 			goDetailForm.append(getInputHiddenTag('type',typeVal))
	 			.append(getInputHiddenTag('keyword',keywordVal))
	 		}
			goDetailForm.appendTo('body').submit
	})
});
