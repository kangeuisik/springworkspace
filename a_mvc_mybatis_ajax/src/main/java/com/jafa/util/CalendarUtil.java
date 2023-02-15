package com.jafa.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jafa.domain.DateVO;
//달력 구현
public class CalendarUtil {
	
	
	
	public static List<DateVO> getDate(int year, int month){
		List<DateVO> dateList = new ArrayList<DateVO>();
		Calendar cal = Calendar.getInstance(); // 오늘날짜
		//월의 첫번째날의 요일
		//이전달
		cal.set(year,month, 1); //2월1일
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);//수요일 4
		
		for(int i=0; i<firstDay-1;i++) {
			cal.add(Calendar.DATE, -1);
			DateVO vo = DateVO.builder()
					.year(cal.get(Calendar.YEAR))
					.month(cal.get(Calendar.MONTH)+1)
					.dayOfMonth(cal.get(Calendar.DATE))
					.dayOfWeek(cal.get(Calendar.DAY_OF_WEEK))
					.build();
			dateList.add(vo);
		}
		//정렬
		dateList.sort((vo1,vo2)->vo1.getDayOfMonth()-vo2.getDayOfMonth());
		
		
		//이번달
		cal = Calendar.getInstance();
		cal.set(year,month, 1);
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); //2월 28
		for(int i = 1; i<=lastDayOfMonth; i++) {
			cal.set(year, month,i);
			DateVO vo = DateVO.builder()
					.year(cal.get(Calendar.YEAR))
					.month(cal.get(Calendar.MONTH)+1)
					.dayOfMonth(cal.get(Calendar.DATE))
					.dayOfWeek(cal.get(Calendar.DAY_OF_WEEK))
					.build();
			dateList.add(vo);
		}
	
		//다음달
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		int repeat = 7-cal.get(Calendar.DAY_OF_WEEK);
		for(int i=0;i<repeat;i++) {
			cal.add(Calendar.DATE, 1);
			DateVO vo = DateVO.builder()
					.year(cal.get(Calendar.YEAR))
					.month(cal.get(Calendar.MONTH)+1)
					.dayOfMonth(cal.get(Calendar.DATE))
					.dayOfWeek(cal.get(Calendar.DAY_OF_WEEK))
					.build();
			dateList.add(vo);
		}
		return dateList; 
	}
	
	
	
	
	public static void main(String[] args) {
		
		//System.out.println(getDate(2023,1));
	}
}
