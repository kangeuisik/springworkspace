package spring1;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {

	public void insert() {
		System.out.println("memberDao");
		System.out.println("회원가입");
	}
}
