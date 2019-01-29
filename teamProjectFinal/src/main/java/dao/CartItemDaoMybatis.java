package dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;

import domain.CartItemVO;

public class CartItemDaoMybatis implements CartItemDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public CartItemDaoMybatis (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public CartItemVO selectByItem(String item) {
		
		return sqlSessionTemplate.selectOne("CartItemDao.selectByItem", item);
	}

	@Override
	public List<CartItemVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemVO selectByNum(int num) {
		return sqlSessionTemplate.selectOne("CartItemDao.selectByNum", num);
	}
}