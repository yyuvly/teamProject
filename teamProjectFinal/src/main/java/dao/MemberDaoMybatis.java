package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.Member;

@Repository
public class MemberDaoMybatis implements MemberDao{

private SqlSessionTemplate sqlSessionTemplate;

	public MemberDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public Member selectById(String id) {
		Member member = sqlSessionTemplate.selectOne("memberDao.selectById", id);
		return member;
	}

	@Override
	public void insert(Member member) {
		sqlSessionTemplate.insert("memberDao.insert", member);
	}

	@Override
	public void update(Member member) {
		sqlSessionTemplate.update("memberDao.update", member);
	}

	@Override
	public void delete(Member member) {
		sqlSessionTemplate.delete("memberDao.delete", member);
	}

}
