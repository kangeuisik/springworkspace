package com.jafa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jafa.domain.MemberVO;
import com.jafa.domain.TransferDTO;
import com.jafa.exception.InsufficientException;
import com.jafa.exception.NotFoundMemberException;
import com.jafa.repository.AccountRepository;
@Service
public class AccountService {
	@Autowired
	AccountRepository rep;
	
	@Transactional
	public void pointTransfer(TransferDTO dto) {
		//보낼금액
		int amount = dto.getAmount();	
		//보내는 사람
		MemberVO vo1 = MemberVO.builder()
				.memberName(dto.getFromMemberName())
				.pointAccount(dto.getFromAccount())
				.build();
		MemberVO memberCheck1 = rep.memberCheck(vo1);
		if(memberCheck1==null) throw new NotFoundMemberException();
		if(memberCheck1.getPoint()<dto.getAmount()) throw new InsufficientException();
		rep.adjustPoint(vo1, amount*(-1));
		
		//받는놈
		MemberVO vo2 = MemberVO.builder()
				.memberName(dto.getToMemberName())
				.pointAccount(dto.getToAccount())
				.build();
		MemberVO memberCheck2 = rep.memberCheck(vo2);
		if(memberCheck2==null) throw new NotFoundMemberException();
			rep.adjustPoint(vo2, amount);
	}
}

