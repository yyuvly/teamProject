package service;

import javax.servlet.http.Cookie;

import domain.GoodsVO;

public class CookieRegisterService {
	
	public Cookie regist(GoodsVO regReq) { 
							// 상품번호에 구매개수가 저장된다.
		Cookie cookie = new Cookie(Integer.toString(regReq.getNum()), Integer.toString(regReq.getCount()));
		return cookie;
	}
	
}
