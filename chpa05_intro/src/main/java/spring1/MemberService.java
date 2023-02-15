package spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberService {
	
	private MemberDao memberDao;
	
	@Autowired
	public void register() {
		memberDao.insert();
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
