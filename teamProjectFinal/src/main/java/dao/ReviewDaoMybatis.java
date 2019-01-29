package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.PageCriteria;
import domain.ReviewVO;

@Repository
public class ReviewDaoMybatis implements ReviewDao{
	private SqlSessionTemplate sqlSessionTemplate;
	public ReviewDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("reviewDao.reviewcount");
	}
	@Override
	public List<ReviewVO> list(PageCriteria pc) {
		return sqlSessionTemplate.selectList("reviewDao.reviewlist", pc);
	}
	@Override
	public int hotelcount() {
		return sqlSessionTemplate.selectOne("reviewDao.hotelreviewcount");
	}
	@Override
	public List<ReviewVO> hotellist(PageCriteria pc) {
		return sqlSessionTemplate.selectList("reviewDao.hotelreviewlist", pc);
	}
	@Override
	public int goodscount() {
		return sqlSessionTemplate.selectOne("reviewDao.goodsreviewcount");
	}
	@Override
	public List<ReviewVO> goodslist(PageCriteria pc) {
		return sqlSessionTemplate.selectList("reviewDao.goodsreviewlist", pc);
	}
	@Override
	public void regist(ReviewVO reviewVO) {
		sqlSessionTemplate.insert("reviewDao.regist", reviewVO);
	}
}
