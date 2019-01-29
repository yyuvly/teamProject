package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Member;
import service.MemberService;

@Controller
public class MypageController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/mypage/{id}", method=RequestMethod.GET)
	public String mypage(@PathVariable String id, Model model) {
		Member member = memberService.detail(id);
		if(member == null) {}
		model.addAttribute("member", member);
		return "/member/member/mypage";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "/member/member/invalidId";
	}
}
