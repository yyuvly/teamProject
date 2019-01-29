package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.OrdersDao;
import domain.OrdersVO;
import domain.PageCriteria;

@Service
public class OrdersServiceImpl implements OrdersService {
	private OrdersDao ordersDao;
	
	public OrdersDao getOrdersDao() {
		return ordersDao;
	}
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	@Override
	public int count() {
		return ordersDao.count();
	}
	@Override
	public List<OrdersVO> list(PageCriteria pc) {
		return ordersDao.list(pc);
	}
	@Override
	public OrdersVO Regisert(OrdersVO ordersVO) {
		ordersDao.insert(ordersVO);
		return null;/////////???????????
	}
	@Override
	public List<OrdersVO> selectById(String id) {
		List<OrdersVO> Orders = ordersDao.selectById(id);
		return Orders;
	}
	@Override
	public OrdersVO selectByNum(int num) {
		OrdersVO OrderItems = ordersDao.selectByNum(num);
		return OrderItems;
	}
	
}
