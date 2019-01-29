package service;

import org.springframework.stereotype.Service;

import dao.CartItemDao;
import domain.CartItemVO;

@Service
public class CartRegisterServiceImpl implements CartRegisterService{
	private CartItemDao cartItemDao;
	
	public CartItemDao getCartItemDao() {
		return cartItemDao;
	}
	
	public void setCartItemDao(CartItemDao cartItemDao) {
		this.cartItemDao = cartItemDao;
	}
	
	@Override
	public CartItemVO searchItem(String num) {
		try {
			int tmp = Integer.parseInt(num);
			CartItemVO cartItem = cartItemDao.selectByNum(tmp);
			if(cartItem == null) {
				return null;
			}			
			return cartItem;
			
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public CartItemVO searchItem(int num) {

		CartItemVO cartItem = cartItemDao.selectByNum(num);
		if(cartItem == null) {
			return null;
		}
		return cartItem;
	}
}
