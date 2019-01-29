package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.InquiryVO;

@Repository  // 이건 뭐야
public class InquiryDaoMybatis implements InquiryDao { // 인터페이스 InquiryDao를 구현한 Dao
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public InquiryDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void selSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<InquiryVO> list() {
		return sqlSessionTemplate.selectList("inquiryDao.list");
	}
	@Override
	public InquiryVO select(int num) {
		InquiryVO vo = (InquiryVO) sqlSessionTemplate.selectOne("inquiryDao.select", num);
		return vo;
	}
	@Override
	public void insert(InquiryVO inquiryVO) {
		sqlSessionTemplate.insert("inquiryDao.insert", inquiryVO);
	}
	@Override
	public int update(InquiryVO inquiryVO) {
		return sqlSessionTemplate.update("inquiryDao.update", inquiryVO);
	}
	@Override
	public int updateReadCount(int num) {
		return sqlSessionTemplate.update("inquiryDao.updateCount", num);
	}
	@Override
	public int delete(InquiryVO inquiryVO) {
		return sqlSessionTemplate.delete("inquiryDao.delete", inquiryVO);
	}
	@Override
	public int deleteAll() {
		return sqlSessionTemplate.update("inquiryDao.deleteAll");
	}

	@Override
	public void replyInsert(InquiryVO inquiryVO) {
		sqlSessionTemplate.insert("inquiryDao.replyInsert", inquiryVO);
	}

	@Override
	public void replyUpdate(InquiryVO inquiryVO) {
		sqlSessionTemplate.update("inquiryDao.replyUpdate", inquiryVO);
	}
}