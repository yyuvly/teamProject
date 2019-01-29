package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Member;
import service.MemberService;

@Controller
public class MemberDetailController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
	
	@RequestMapping("/memberDetail/{id}")
	public String detail(@PathVariable String id, Model model) {
		Member member = memberService.detail(id);
		if(member == null) {}
		model.addAttribute("member", member);
		return "/member/member/memberDetail";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "/member/member/invalidId";
	}
}
