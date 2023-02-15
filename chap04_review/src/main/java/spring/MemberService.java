package spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class MemberService {
	
	MemberDao memberDao;
	
	@Autowired
	public void setMemberdao(Optional<MemberDao> memberdaoOpt) {
		if(memberdaoOpt.isPresent()) {
			this.memberDao = memberdaoOpt.get();
		}else {
			this.memberDao = null;
		}
		
	}
	public void register() {
		System.out.println("MemberService : 회원가입");
		this.memberDao.insert();
	}

	
}
