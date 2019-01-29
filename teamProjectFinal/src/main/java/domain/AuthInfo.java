package domain;

public class AuthInfo {
	private String id;
	private String password;
	
	public AuthInfo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
