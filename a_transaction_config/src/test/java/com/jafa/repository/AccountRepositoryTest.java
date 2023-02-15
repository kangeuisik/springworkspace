package com.jafa.repository;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.MemberVO;
import com.jafa.exception.NotFoundMemberException;

public class AccountRepositoryTest extends AppTest{
	@Autowired
	AccountRepository rep;
	
	@Test
	public void test() {
		//보내는 사람
		MemberVO vo1 = MemberVO
				.builder()
				.pointAccount("1588")
				.memberName("손흥민")
				.build();
		MemberVO memberCheck1 = rep.memberCheck(vo1);
		if(memberCheck1==null) { // 회원이 db내에 없으면~
			throw new NotFoundMemberException();
		}
		rep.adjustPoint(vo1, -5000);
	
	
	//받는사람
		MemberVO vo2 = MemberVO
				.builder()
				.pointAccount("7604")
				.memberName("김민재")
				.build();
		MemberVO memberCheck2 = rep.memberCheck(vo2);
		if(memberCheck2==null) { // 회원이 db내에 없으면~
			throw new NotFoundMemberException();
		}
		rep.adjustPoint(vo2, +5000);
	}
}
