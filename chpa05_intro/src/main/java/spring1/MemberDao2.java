package spring1;

import org.springframework.stereotype.Component;

@Component
public class MemberDao2 {

	public void insert() {
		System.out.println("memberDao");
		System.out.println("회원가입");
	}
}
