package spring;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterRequest {//MemberDTO

	private String email;
	private String password;
	private String cofirmPassword;
	private String name;
	
	public boolean isPasswordEqualToConfirmPassword() {
		
		return password.equals(cofirmPassword);
	}

	
	


}
