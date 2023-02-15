package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
		
		private MemberDao memberDao;
		
		public MemberRegisterService() {
			// TODO Auto-generated constructor stub
		}
		@Autowired
		public MemberRegisterService(MemberDao memberDao) {
			this.memberDao = memberDao;
			//주입을 받는다
		}
		
		public Long register(RegisterRequest req) {
			//이메일로 회원데이터 조회
			Member member = memberDao.selectByEmail(req.getEmail());
			if(member!=null) {// 사용자가 입력한 이메일이 DB에 있다면
				throw new DuplicateMemberException("dup email"+req.getEmail());
			}
			//사용자가 입력한 이메일이 DB에 없다면! 회원가입을 진행
			Member newMember = new Member(
					req.getEmail(),
					req.getPassword(),
					req.getName(),
					LocalDateTime.now());
			memberDao.insert(newMember);
			return newMember.getId();
		}
}
