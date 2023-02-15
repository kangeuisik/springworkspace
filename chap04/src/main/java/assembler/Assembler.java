package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService reqSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDao();//객체생성
		reqSvc = new MemberRegisterService(memberDao);//생성자 주입
		
		pwdSvc = new ChangePasswordService();//객체생성
		pwdSvc.setMemberDao(memberDao);//세터를 통한 주입
		
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getReqSvc() {
		return reqSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	

}
