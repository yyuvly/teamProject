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
import domain.DeleteCommand;
import exception.IdPasswordMatchingException;
import service.MemberService;
import validator.DeleteCommandValidator;

@Controller
@RequestMapping(value="/delete")
public class DeleteController {
	private MemberService memberService;

	public void setMemberService(
			MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String form(
			@ModelAttribute("command") DeleteCommand deleteCmd) {
		return "/member/del/deleteForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String submit(
			@ModelAttribute("command") DeleteCommand deleteCmd,
			Errors errors, HttpSession session, HttpServletResponse response) throws IOException {
		new DeleteCommandValidator().validate(deleteCmd, errors);
		if(errors.hasErrors()) {
			return "/member/del/deleteForm";
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");

		try {
			memberService.delete(
					authInfo.getId(),
					deleteCmd.getConfirmPassword());
			session.removeAttribute("authInfo");
			return "/member/del/delete";
		} catch(IdPasswordMatchingException e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호를 잘못 입력하셨습니다.');</script>");
			out.flush();
			return "/member/del/deleteForm";
		}
	}
}