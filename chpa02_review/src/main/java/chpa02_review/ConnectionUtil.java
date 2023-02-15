package chpa02_review;

public class ConnectionUtil {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public void connectionInfo() {
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
