package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.AuthInfo;
import domain.ChangeCommand;
import exception.IdPasswordMatchingException;
import service.MemberService;
import validator.ChangeCommandValidator;

@Controller
@RequestMapping(value="/change")
public class ChangeController {
	private MemberService memberService;

	public void setMemberService(
			MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String form(
			@ModelAttribute("command") ChangeCommand passwordCmd) {
		return "/member/edit/changeForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String submit(
			@ModelAttribute("command") ChangeCommand passwordCmd,
			Errors errors, HttpSession session, HttpServletResponse response) throws IOException {
		new ChangeCommandValidator().validate(passwordCmd, errors);
		if(errors.hasErrors()) {
			return "/member/edit/changeForm";
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		//기존의 세션을 가져와서 로그인한 사용자 판별
		try {
			memberService.changePassword(
					authInfo.getId(),
					passwordCmd.getCurrentPassword(),
					passwordCmd.getNewPassword());
			return "/member/edit/change";
		} catch(IdPasswordMatchingException e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호를 잘못 입력하셨습니다.');</script>");
			out.flush();
			return "/member/edit/changeForm";
		}
	}
}
