package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.OrdersVO;
import domain.PageCriteria;

@Repository
public class OrdersDaoMybatis implements OrdersDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	public OrdersDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("ordersDao.orderscount");
	}
	@Override
	public List<OrdersVO> list(PageCriteria pc) {
		return sqlSessionTemplate.selectList("ordersDao.orderslist", pc);
	}
	@Override
	public void insert(OrdersVO ordersVO) {
		sqlSessionTemplate.insert("ordersDao.insert", ordersVO);
	}
	@Override
	public List<OrdersVO> selectById(String id) {
		return sqlSessionTemplate.selectList("ordersDao.selectById", id);
	}
	@Override
	public OrdersVO selectByNum(int num) {
		OrdersVO vo =(OrdersVO) sqlSessionTemplate.selectOne("ordersDao.selectByNum", num);
		return vo;
	}
}
