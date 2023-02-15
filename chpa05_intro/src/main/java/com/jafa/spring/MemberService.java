package com.jafa.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberDao2")
public class MemberService {
	
	private MemberDao mDao;
	
	@Autowired
	public void register() {
		mDao.insert();
	}

	public void setMemberDao(MemberDao mDao) {
		this.mDao = mDao;
	}
	
}
