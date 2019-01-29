package dao;

import domain.Member;

public interface MemberDao {	
	public abstract Member selectById(String id);
	
	public abstract void insert(Member member);	
	
	public abstract void update(Member member);
	
	public abstract void delete(Member member);
}
