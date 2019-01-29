package domain;

import org.apache.ibatis.type.Alias;

import exception.IdPasswordMatchingException;

@Alias("member")
public class Member {
	private Long num;			//시퀀스넘버
	private String id;			//id
	private String password;	//비밀번호
	private String name;		//이름
	private String phone;		//폰번호
	private String email;		//이메일
	private String address;		//주소
	
	public Member() {}
	
	public Member(
			String id, String password, String name, String phone, String address, String email)
	{
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//암호변경 기능을 구현하는 메서드
	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword))
			throw new IdPasswordMatchingException();
		this.password = newPassword;
	}
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
}
