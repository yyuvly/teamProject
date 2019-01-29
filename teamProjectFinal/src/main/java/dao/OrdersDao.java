package dao;

import java.util.List;

import domain.OrdersVO;
import domain.PageCriteria;

public interface OrdersDao {
	public abstract int count();
	public abstract List<OrdersVO> list(PageCriteria pc);
	public abstract void insert(OrdersVO ordersVO);
	public abstract List<OrdersVO> selectById(String id);
	public abstract OrdersVO selectByNum(int num);
}
