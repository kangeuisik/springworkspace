package com.jafa.domain;

import lombok.Getter;

@Getter
public class PageNation {
	private Criteria criteria; 
	private int startPage; // 시작페이지 버튼 번호
	private int endPage; // 마지막 페이지버튼 번호
	private int tempEndPage; // 실제 마지막 페이지버튼 번호
	private int totalCount; // 총게시물 수
	
	private int displayPageNum =10; //화면에 보여질 페이지 버튼 수
	private boolean prev; // 이전페이지버튼 활성화 여부
	private boolean next; // 다음페이지버튼 활성화 여부
	
	public PageNation(Criteria criteria, int totalCount) {
		
		this.criteria = criteria; 
		this.totalCount = totalCount;
		int pageNum = criteria.getPageNum(); // 페이지번호
		//  올림(pageNum/displayPageNum)*displayPageNum
		
		endPage =(int) Math.ceil(pageNum/(double)displayPageNum)*displayPageNum;
			//나누었을때 소수기때문에 double 
		startPage = endPage - displayPageNum +1;
		
		tempEndPage = (int) Math.ceil(totalCount/(double)criteria.getAmount());
		System.out.println("끝페이지 :"+endPage);
		System.out.println("마지막 페이지"+tempEndPage);
		prev = startPage != 1;
		next = endPage < tempEndPage;
		if(endPage > tempEndPage) endPage =tempEndPage;
	}
	
}
/*
 * displayPageNum = 10
  1~10 : [1][2]..[9][10]
  	endPage : 10
  	startPage : 10-10+1
  	
  11~20 : [11][12]..[19][20]
  	endPage : 20
  	startPage : 20-10+1
  21~30 : [21][22]..[29][30]
  	endPage : 30
  	startPage : 30(endPage)-10(displayNum)+1
  	
  	
  올림(페이지번호/버튼수)*버튼수	
 */



/* displayPageNum =10
 * totalCount =412
 * 
 *  1~10페이지 :
 *  [1][2][3][4][5]...[10] [다음페이지]
 *  startPage = [1]
 *  endPage = [10]
 *  prev : false
 *  next : true
 *  
 *  
 *  11~20페이지 :
 *  [11][12][13][14][15]...[20] [다음페이지]
 *  startPage = [11]
 *  endPage = [20]
 *  prev : true
 *  next : true
 * 
 *  41~50페이지 :
 *  [41][42][43]...[50] [다음페이지]
 *  startPage = [41]
 *  endPage = [50]
 *  prev : true
 *  next : false
 * 
 * 	실제로 보여질 41~50페이지
 * 	[이전페이지] [41][42][43]...[50] 
 *  startPage = [41]
 *  endPage = [42] 올림(총게시물/페이징처리수)
 *  prev : true
 *  next : false  
 */
