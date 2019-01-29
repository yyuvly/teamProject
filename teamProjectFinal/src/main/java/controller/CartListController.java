package controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.AuthInfo;
import domain.CartItemVO;
import service.CartRegisterService;

@Controller
public class CartListController {	

	private CartRegisterService cartRegisterService;
	
	public CartRegisterService getCartRegisterService() {
		return cartRegisterService;
	}
	
	public void setCartRegisterService(CartRegisterService cartRegisterService) {
		this.cartRegisterService = cartRegisterService;
	}

	@RequestMapping(value="/goods/cart/cart", method=RequestMethod.GET)
	public String cartList(HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
		try {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo==null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>alert('로그인 해주세요'); location.href='/teamProject/login';</script>");
			out.flush();
			
		}else {
		
		HashMap<String, CartItemVO> cartItems = new HashMap<String, CartItemVO>();
		
		int total =0;
		int totalNum=0;
		int itemNum=0;
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i<cookies.length;i++){
	
			
			CartItemVO cartItem = cartRegisterService.searchItem(cookies[i].getName());
			if (cartItem != null) {
				int tmp = Integer.parseInt(cookies[i].getValue())* cartItem.getPrice();
				total +=tmp;
				cartItems.put(Integer.toString(cartItem.getNum()), cartItem);
				totalNum += Integer.parseInt(cookies[i].getValue());
				itemNum++;
				session.setAttribute("item", cartItem.getItem());
			}
		}
		if(itemNum!=0) {
			session.setAttribute("ItemNum", itemNum);
		}
		session.setAttribute("total", total); //totalPrice
		session.setAttribute("totalNum", totalNum);
		model.addAttribute("cartItems",cartItems);
		
		return "/goods/cart/cart";
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@RequestMapping(value="/goods/cart/delete/{num}", method=RequestMethod.GET)
	public String itemDelete(@PathVariable int num, @ModelAttribute CartItemVO cartItem, Model model,
			HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		
		CartItemVO deleteItem = cartRegisterService.searchItem(num);
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i<cookies.length;i++){
			if (cookies[i].getName().equals(Integer.toString(deleteItem.getNum()))) {
				String tmp = cookies[i].getName();
				Cookie cookie = new Cookie(tmp, cookies[i].getValue());
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		cartList(response, request, model, session);
		
		return "redirect:/goods/cart/cart";
	}

}
