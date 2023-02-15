package spring;

public class ChangePasswordService {
	
	private MemberDao memberDao;

	public void changePassword(String email,String oldPwd,String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member ==null) {//회원을 찾을수 없다면
			throw new MemberNotFoundException(); //회원찾을수 없음
			//회원있으면
		}
		member.changePassword(oldPwd, newPwd);
			//새로운 비밀번호 설정
		memberDao.update(member); //새로운 비밀번호 설정된 채로 업데이트
	}
	
	
	//setter(수정자) 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}
