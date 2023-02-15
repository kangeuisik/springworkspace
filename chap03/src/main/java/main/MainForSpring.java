package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import assembler.Assembler;
import config.AppCtx;
import config.test2.AppConfig;
import config.test.AppConfig2;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongPasswordException;

public class MainForSpring {
	//ApplicationContext가 상위
		private static ApplicationContext ctx = null;//

	
	public static void main(String[] args) throws IOException {
		//스프링 컨테이너
		
//		어노테이션 방식
//			ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		//XML 방식
//			ctx = new GenericXmlApplicationContext("classpath:AppCtx.xml");
		
		//두개 이상의 config 활용(annotation)
//			ctx = new AnnotationConfigApplicationContext(AppConfig1.class,AppConfig2.class);
		//두개이상의 config 활용 (xml)
//			ctx = new GenericXmlApplicationContext("classpath:test01/conf1.xml","classpath:test01/conf2.xml");
		
		//@Import 사용(annotation)
//			ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//@import 사용(xml)
			ctx = new GenericXmlApplicationContext("classpath:test2/conf.xml");
			
			
		//scaner기능과 같음 시스템으로 입력받음
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요");
			
			String command = reader.readLine();

			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}else if(command.startsWith("new ")) {//회원가입
				processNewCommand(command.split(" "));
			}else if(command.startsWith("change ")) {//비밀번호변경
				processChangeCommand(command.split(" "));
			}else if(command.equals("list")) {//모든회원 목록
				processListCommand();
			}else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));	
			}else if(command.equals("version")) {
				processVersionCommand();
			}
			else {
				printHelp();
			
			}
		}
	}


	private static void processNewCommand(String[] arg) {//회원가입
		if(arg.length!=5) { // 배열이 5개가 안되면 돌려 보내기
			printHelp();
			return;
		}
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setCofirmPassword(arg[4]);
		//
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
		//비밀번호가 일치확인
		if(!req.isPasswordEqualToConfirmPassword()) { //암호와 암호확인이 일치하지않으면
			System.out.println("암호와 암호확인 일치하지 않습니다.\n");
			return;
		}//암호와 암호확인이 일치하면
		try {//회원가입
			regSvc.register(req);
			System.out.println("등록했습니다.\n");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	
	}
	private static void processChangeCommand(String[] arg) {//비밀번호 변경
		if(arg.length!=4) { // 배열이 4개가 안되면 돌려 보내기
			printHelp();
			return;
		}
		//change 이메일 현재비번 변경비번
		
		// 어셈블러 컨테이너에서 객체를 가져옴//
		ChangePasswordService pwdSvc =
				ctx.getBean("changePwdSvc",ChangePasswordService.class);
		try {
			pwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");			
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지않는 이메일입니다.\n");
		} catch (WrongPasswordException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다.\n");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("모든회원목록 : list");
		System.out.println("신규회원 : new 이메일 이름 암호 암호확인");
		System.out.println("암호변경 : change 이메일 현재비밀번호 변경비밀번호");
		System.out.println("회원상세 : info 이메일");
		System.out.println("버젼확인 : version");
		System.out.println();
		
	}
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("memberListPrinter",MemberListPrinter.class);
		listPrinter.printAll();
		
	}
	//회원정보
	private static void processInfoCommand(String[] arg) {
		if(arg.length!=2) { //{info, 이메일}
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter",MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	private static void processVersionCommand() {
		VersionPrinter version = ctx.getBean(VersionPrinter.class);
		version.print();
		
	}	
	
}
