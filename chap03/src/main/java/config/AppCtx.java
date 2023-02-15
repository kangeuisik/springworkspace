package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberRegisterService memberRegSvc() {//생성자
		return new MemberRegisterService(memberDao());
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao()); //세터(수정자)
		return pwdSvc;
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	@Bean
	public MemberListPrinter memberListPrinter() {
		//생성자 주입, Constructer DI
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	//회원상세정보
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		//수정자 주입 , Setter DI(dependency Injection)
		memberInfoPrinter.setMemberDao(memberDao());
		memberInfoPrinter.setPrinter(memberPrinter());
		return memberInfoPrinter;
	}
	@Bean
	public VersionPrinter versionPrinter() {
		return new VersionPrinter()
				.setMajorVersion(5)
				.setMinorVersion(0);
	}
	
}