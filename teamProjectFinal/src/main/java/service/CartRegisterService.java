package service;

import domain.CartItemVO;

public interface CartRegisterService {
	
	public abstract CartItemVO searchItem(String item);
	public abstract CartItemVO searchItem(int num);

}
