package service;


import java.util.List;

import domain.OrdersVO;
import domain.PageCriteria;

public interface OrdersService {
	public abstract int count();
	public abstract List<OrdersVO> list(PageCriteria pc);
	public abstract OrdersVO Regisert(OrdersVO ordersVO);
	public abstract List<OrdersVO> selectById(String id);
	public abstract OrdersVO selectByNum(int num);
}
