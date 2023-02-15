package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	//시퀀스, 회원가입을 하는사람의 번호
	private static long nextId = 0;
	
	//데이터베이스 테이블
	private Map<String, Member> map = new HashMap<>(); 
	//map에 지정한 첫번재 변수 'key'는 primarykey
	
	public Member selectByEmail(String email) {	
		return map.get(email);
	}

	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		
	}
	public void update(Member member) {
		map.put(member.getEmail(), member);
		
	}
	public Collection<Member> selectAll(){
		return map.values();
	}

}
