console.log('list.js');



$(function(){
	
	let typeValue = getSearchParam('type');
	let keywordValue = getSearchParam('keyword');
	let category = $('.category').val();
	console.log(category);
	// 페이지 이동
	$('.pagination a').on('click',function(e){
		e.preventDefault();
		let pageForm = $('<form>');
		pageForm.empty();
		pageForm.attr('method','get')
			.attr('action',`${contextPath}/board/list/${category}`)
			.append(getInputHiddenTag('page',$(this).attr('href')))
		if(typeValue !=null && keywordValue != null){
			pageForm.append(getInputHiddenTag('type',typeValue))
				.append(getInputHiddenTag('keyword',keywordValue))
		}
		pageForm.appendTo('body')
			.submit();
	});
	
	//검색
	$('.searchForm button').on('click',function(){
		let category = $('.searchForm').find('.category').val();
		$('.searchForm').attr("action",`${contextPath}/board/list/${category}`)
			.submit();
	})
	
	// 상세게시물로 이동
	$('.goDetail').on('click',function(e){
		e.preventDefault();
		let goDetailForm = $('<form>');
		goDetailForm.empty();
		goDetailForm.attr('method','get')
			.attr('action',`${contextPath}/board/detail`)
			.append(getInputHiddenTag('bno',$(this).attr('href')))
			.append($('.page'))
		if(typeValue !=null && keywordValue != null){
			goDetailForm.append(getInputHiddenTag('type',typeValue))
				.append(getInputHiddenTag('keyword',keywordValue))
		}				
		goDetailForm.appendTo('body').submit()	
	})
});