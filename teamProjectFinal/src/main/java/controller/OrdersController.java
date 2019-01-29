package controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.AuthInfo;
import domain.CartItemVO;
import domain.HotelVO;
import domain.Member;
import domain.OrdersVO;
import domain.PageCriteria;
import domain.PageMaker;
import service.CartRegisterService;
import service.MemberService;
import service.OrdersService;

@Controller
@SessionAttributes("ordersVO")
public class OrdersController {

	private OrdersService ordersService;
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService=ordersService;
	}
	public OrdersService getOrdersService() {
		return ordersService;
	}


	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	private CartRegisterService cartRegisterService;
	public CartRegisterService getCartRegisterService() {
		return cartRegisterService;
	}
	public void setCartRegisterService(CartRegisterService cartRegisterService) {
		this.cartRegisterService = cartRegisterService;
	}


	@RequestMapping(value="/orders/list", method=RequestMethod.GET)
	public String list() {
		return "/main";
	}
	@RequestMapping(value="/orders/list", method=RequestMethod.POST)
	public String list(Model model,PageCriteria pc) {
		PageMaker pm=new PageMaker();
		pm.setPc(pc);
		pm.setTotalCount(ordersService.count());
		model.addAttribute("ordersList", ordersService.list(pc));
		model.addAttribute("pagemaker", pm);
		return "/orders/list";
	}


	@RequestMapping(value="/orders/item", method=RequestMethod.POST)
	public String orderItem(@RequestParam(value="payment", defaultValue="null")String bank,
			HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
		try{
			if(bank.equals("null")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('결제 방법을 선택해 주세요'); history.go(-1);</script>");
				out.flush();

			}else {

				AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
				String id = authInfo.getId();
				Member member = memberService.detail(id);
				session.setAttribute("member", member);
				model.addAttribute("orderData", new OrdersVO());

				if (bank.equals("false")) {
					return "/orders/item_card";
				}
				return "/orders/item_bank";
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="/orders/itemConfirm", method=RequestMethod.POST)
	public String orderItem(@ModelAttribute("orderData")OrdersVO regReq,
			HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
		try {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			String id = authInfo.getId();
			Cookie[] cookies = request.getCookies();
			for(int i = 0; i<cookies.length;i++){
				CartItemVO cartItem = cartRegisterService.searchItem(cookies[i].getName());
				Date today = new Date();
				SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd");
				String num = form.format(today);
				if (cartItem != null) {
					
					regReq.setItem(cartItem.getItem());
					regReq.setCount(Integer.parseInt(cookies[i].getValue()));
					regReq.setPrice(Integer.parseInt(cookies[i].getValue()) * cartItem.getPrice());
					regReq.setType("item");
					regReq.setImg(cartItem.getImg());
					regReq.setId(id);
					regReq.setOrdernum(num+id);
					ordersService.Regisert(regReq);
					cookieDelete(cookies[i].getName(), request, response);
				}
			}
			return "/orders/itemConfirm";

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@RequestMapping(value="/orders/hotel", method=RequestMethod.POST)
	public String orderHotel(@RequestParam(value="payment", defaultValue="null")String bank,
			HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
		try{
			if(bank.equals("null")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('결제 방법을 선택해 주세요'); history.go(-1);</script>");
				out.flush();

			}else {

				HotelVO hotelVO = (HotelVO)session.getAttribute("hotelVO");
				String date = hotelVO.getCheckin()+"~"+hotelVO.getCheckout();
				session.setAttribute("date", date);
				model.addAttribute("orderData", new OrdersVO());

				if (bank.equals("false")) {
					return "/orders/hotel_card";
				}
				return "/orders/hotel_bank";
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="/orders/hotelConfirm", method=RequestMethod.POST)
	public String hotelItem(@ModelAttribute("orderData")OrdersVO regReq,
			HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
		try {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			String id = authInfo.getId();
			HotelVO hotelVO = (HotelVO)session.getAttribute("hotelVO");
			
			Date today = new Date();
			SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd");
			String num = form.format(today);
			
			regReq.setItem((String)session.getAttribute("date"));
			regReq.setCount(hotelVO.getA_cnt());
			regReq.setPrice(hotelVO.getPrice());
			regReq.setType("hotel");
			regReq.setImg("IMG_9785");
			regReq.setId(id);
			regReq.setOrdernum(num+id);
			ordersService.Regisert(regReq);
			
		return "/orders/itemConfirm";

	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}
	public void cookieDelete(String num, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i<cookies.length;i++){
			if (cookies[i].getName().equals(num)) {
				String tmp = cookies[i].getName();
				Cookie cookie = new Cookie(tmp, cookies[i].getValue());
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
	}
	@RequestMapping("/ordersDetail/{id}")
	public String detail(@PathVariable String id, Model model) {
			List<OrdersVO> ordersVO = ordersService.selectById(id);		
		if(ordersVO == null) {}
		model.addAttribute("orderItem", ordersVO);		
		return "/orders/ordersDetail";
	}

}
