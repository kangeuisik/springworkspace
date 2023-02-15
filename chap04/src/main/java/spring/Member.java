package spring;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {
		@Setter
		private Long id;
		private String email;
		private String password;
		private String name;
		private LocalDateTime registerDateTime;
		
		public Member(String email, String password, String name, LocalDateTime registerDateTime) {
			this.email = email;
			this.password = password;
			this.name = name;
			this.registerDateTime = registerDateTime;
		}
		//비밀번호 변경
		public void changePassword(String oldPwd, String newPwd) {
			if(!this.password.equals(oldPwd)) { //기존 비밀번호와 일치하지 않으면
				throw new WrongPasswordException(); //예외발생
			}
			this.password = newPwd;
			
		}

}
