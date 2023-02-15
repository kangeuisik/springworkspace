package config;

import org.springframework.beans.factory.annotation.Qualifier;
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
		return new MemberRegisterService();
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
//		pwdSvc.setMemberDao(memberDao()); //세터(수정자) //Autowired로 자동으로 주입해줌
		return new ChangePasswordService();
	}
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	@Bean(name="printer")
	public MemberPrinter memberPrinter2() {
		return new MemberPrinter();
	}

	@Bean
	public MemberListPrinter memberListPrinter() {
		//생성자 주입, Constructer DI
		return new MemberListPrinter();
	}
	//회원상세정보
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		//수정자 주입 , Setter DI(dependency Injection)
//		memberInfoPrinter.setMemberDao(memberDao());
//		memberInfoPrinter.setPrinter(memberPrinter());
		return memberInfoPrinter;
	}
	@Bean
	public VersionPrinter versionPrinter() {
		return new VersionPrinter();

	}
	
}
