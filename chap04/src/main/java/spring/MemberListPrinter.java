package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	
	private MemberPrinter printer;
	
	//생성자 주입
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public MemberListPrinter() {
		// TODO Auto-generated constructor stub
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m->printer.print(m));
	}
	

}
