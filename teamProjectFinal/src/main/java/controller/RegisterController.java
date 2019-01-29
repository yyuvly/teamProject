package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.RegisterRequest;
import exception.AlreadyExistingMemberException;
import service.MemberService;
import validator.RegisterRequestValidator;

@Controller
public class RegisterController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
	//클라이언트의 요청으로 들어오는 url경로 지정
	@RequestMapping(value="/register/step1")
	public String handleStep1() {
		return "/member/register/step1";
	}

	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/member/register/step1";
	}

	//요청을 처리할 컨트롤러의 메서드에서 요청 파라미터를 사용하기 위한 방법
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(
			@RequestParam(value="agree", defaultValue="false")Boolean agree,
			Model model) {
		if(!agree) {
			return "/member/register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "/member/register/step2";
	}

	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq,
			Errors errors, HttpServletResponse response) throws IOException {
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			return "/member/register/step2";
		}
		try {
			memberService.regist(regReq);
			return "/member/register/step3";
		} catch(AlreadyExistingMemberException e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('중복된 아이디입니다.');</script>");
			out.flush();
			return "/member/register/step2";
		}
	}
}
