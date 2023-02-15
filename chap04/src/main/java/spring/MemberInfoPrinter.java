package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	@Qualifier("printer")
	private MemberPrinter printer;
	
	//회원 상세정보
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member==null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
	

//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

//	public void setPrinter(MemberPrinter printer) {
//		this.printer = printer;
//	}
	
	
}
