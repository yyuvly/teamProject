package controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.AuthInfo;
import domain.HotelVO;
import domain.Member;
import service.MemberService;

@Controller
public class HotelController {
	private MemberService memberService;
	
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value="/hotel/reserve", method=RequestMethod.GET)
	public String reserve(Model model) {
		try {
			model.addAttribute("formData", new HotelVO());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/hotel/reserve";
	}
	
	@RequestMapping(value="/hotel/confirm", method=RequestMethod.POST)
	public String confirm(@ModelAttribute("hotelVO") HotelVO hotelVO, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		try {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			
			if(authInfo != null) {
				String id = authInfo.getId();
				Member member = memberService.detail(id);
				session.setAttribute("member", member);
				
				// String 날짜 date로 변환
				String first = hotelVO.getCheckin();
				SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
				Date firstDate =Date.parse(first);
				String last = hotelVO.getCheckout();
				Date lastDate = Date.parse(last);

				// date 날짜 계산해서 int로 변환
				Calendar c = Calendar.getInstance();
				c.setTime(firstDate);
				Calendar c2 = Calendar.getInstance();
				c2.setTime(lastDate);
				long dDayDiff = c2.getTimeInMillis() - c.getTimeInMillis();
				int day = (int)(Math.floor(TimeUnit.HOURS.convert(dDayDiff,TimeUnit.MILLISECONDS)/24f));

				int price = (hotelVO.getA_cnt()*10000*day);
				hotelVO.setPrice(price);
				session.setAttribute("hotelVO", hotelVO);
				return "/hotel/confirm";
			}else
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인 후 이용가능합니다.'); location.href='/teamProject/login';</script>");
				out.flush();
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
























