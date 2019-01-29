package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.AuthInfo;
import domain.LoginCommand;
import exception.IdPasswordMatchingException;
import service.MemberService;
import validator.LoginCommandValidator;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	//쿠키 추가 후
	@RequestMapping(method=RequestMethod.GET)
	public String form(LoginCommand loginCommand,
			@CookieValue(value="REMEMBER", required=false)Cookie cookie) {
		if(cookie != null) {
			loginCommand.setId(cookie.getValue());
			loginCommand.setRememberId(true);
		}
		return "/member/login/loginForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors,
			HttpSession session, HttpServletResponse response) throws IOException {
				
		new LoginCommandValidator().validate(loginCommand, errors);

		if(errors.hasErrors()) {
			return "/member/login/loginForm";
		}

		try {
			AuthInfo authInfo = memberService.authenticate(
					loginCommand.getId(), loginCommand.getPassword());
			//TODO 세션에 authInfo 저장해야 함
			session.setAttribute("authInfo", authInfo);

			Cookie rememberCookie =
					new Cookie("REMEMBER", loginCommand.getId());
			rememberCookie.setPath("/");

			if(loginCommand.isRememberId()) {				
				rememberCookie.setMaxAge(60*60*24*30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			return "/member/login/loginSuccess";
		} catch (IdPasswordMatchingException e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호를 잘못 입력하셨습니다.');</script>");
			out.flush();
		}
		return "/member/login/loginForm";
	}
}
