package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.GoodsVO;

@Repository
public class GoodsDaoMybatis implements GoodsDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	//DB접속 연결 정보, query 가 들어있는 sqlSessionTemplate
	public GoodsDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<GoodsVO> list() {
		return sqlSessionTemplate.selectList("goodsDao.list");
	}
	
	@Override
	public GoodsVO detail(int num) {
		GoodsVO vo= (GoodsVO) sqlSessionTemplate.selectOne("goodsDao.detail", num);
		return vo;
	}

	@Override
	public GoodsVO divide(int num) {
		GoodsVO vo= (GoodsVO) sqlSessionTemplate.selectOne("goodsDao.description",num);
		return vo;
	}
	
	@Override
	public int delete(GoodsVO goodsVO) {
		return sqlSessionTemplate.delete("goodsDao.delete", goodsVO);
	}
	@Override
	public int update(GoodsVO goodsVO) {
		return sqlSessionTemplate.update("goodsDao.update", goodsVO);
	}
	@Override
	public void insert(GoodsVO goodsVO) {
		sqlSessionTemplate.insert("goodsDao.insert",goodsVO);
	}

}
