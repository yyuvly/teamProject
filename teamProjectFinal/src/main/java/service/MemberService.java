package service;

import domain.AuthInfo;
import domain.Member;
import domain.RegisterRequest;

public interface MemberService {
	public abstract void regist(RegisterRequest reg);

	public abstract AuthInfo authenticate(String id, String password);

	public abstract void changePassword(String id, String oldPassword, String newPassword);
	
	public abstract Member detail(String id);
	
	public abstract void delete(String id, String confirmPassword);
}
