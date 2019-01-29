package dao;

import java.util.List;

import domain.CartItemVO;

public interface CartItemDao {
	public List<CartItemVO> selectAll();
	public CartItemVO selectByItem(String item);
	public CartItemVO selectByNum(int num);

}
