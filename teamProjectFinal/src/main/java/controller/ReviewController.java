package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.OrdersVO;
import domain.PageCriteria;
import domain.PageMaker;
import domain.ReviewVO;
import service.OrdersService;
import service.ReviewService;

@Controller
public class ReviewController {
	
	private ReviewService reviewService;
	public void setReviewService(ReviewService reviewService) {
		this.reviewService=reviewService;
	}
	
	private OrdersService ordersService;
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@RequestMapping(value="/review/list")
	public String list(Model model,PageCriteria pc) {
		PageMaker pm=new PageMaker();
		pm.setPc(pc);
		pm.setTotalCount(reviewService.count());
		model.addAttribute("reviewList", reviewService.list(pc));
		model.addAttribute("pagemaker", pm);
		return "/review/list";
	}
	@RequestMapping(value="/review/hotel")
	public String hotellist(Model model,PageCriteria pc) {
		PageMaker pm1=new PageMaker();
		pm1.setPc(pc);
		pm1.setTotalCount(reviewService.hotelcount());
		model.addAttribute("hotelreviewList", reviewService.hotellist(pc));
		model.addAttribute("hotelpagemaker", pm1);
		return "/review/hotel";
	}
	@RequestMapping(value="/review/goods")
	public String goodslist(Model model,PageCriteria pc) {
		PageMaker pm2=new PageMaker();
		pm2.setPc(pc);
		pm2.setTotalCount(reviewService.goodscount());
		model.addAttribute("goodsreviewList", reviewService.goodslist(pc));
		model.addAttribute("goodspagemaker", pm2);
		return "/review/goods";
	}
	

	@RequestMapping(value="/review/regist/{num}", method=RequestMethod.GET)
	public String regist(ReviewVO reviewVO, @PathVariable int num, Model model) {
		OrdersVO vo=(OrdersVO)ordersService.selectByNum(num);
	
		model.addAttribute("OrderList",vo);
		return "/review/regist";
	}
	
	@RequestMapping(value="/review/regist/{num}", method=RequestMethod.POST)
	public String regits(ReviewVO reviewVO, @PathVariable int num, HttpServletRequest req) {
		try {
			reviewVO.setNum(num);
			reviewVO.setId(req.getParameter("id"));
			reviewVO.setImg(req.getParameter("img"));
			reviewVO.setItem(req.getParameter("item"));
			reviewVO.setContent(req.getParameter("content"));
			reviewVO.setType(req.getParameter("type"));
			System.out.println(reviewVO.toString());
			reviewService.regist(reviewVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/main";
	}
}
