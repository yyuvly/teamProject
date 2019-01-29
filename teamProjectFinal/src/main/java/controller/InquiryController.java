package controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.AuthInfo;
import domain.InquiryVO;
import domain.Member;
import service.InquiryService;
import service.MemberService;


/* 컨트롤러 작성
 * 클라이언트에서 "/board/list"를 요청할 경우 처리할 기능을 구현한다.
 * 컨트롤러 역할을 하는 클래스는 @Controller를 지정
 * 클라이언트 요청을 처리할 메서드는 @RequestMapping을 지정
 */


@Controller
@SessionAttributes("inquiryVO")
// 수정 위해 : inquiryVO란 이름으로 객체가 MVC모델에 추가될 때 세션에도 저장하라는 선언

public class InquiryController {

	private InquiryService inquiryService;
	public void setInquiryService(InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}

	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	// 목록!!!!
	@RequestMapping(value="/inquiry/list")
	public String list(Model model, InquiryVO inquiryVO) {
		try {
			model.addAttribute("inquiryList", inquiryService.list());
			List<InquiryVO> tmp = inquiryService.list();
			for(int i =0; i<tmp.size(); i++) {
				//				InquiryVO tmp2 = tmp.get(i);  tmp2가 쓰인곳이 없어 주석처리함
			}
			return "/inquiry/list";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/inquiry/list";

	}

	// 글 읽기!!!! /inquiry/read/{글번호}
	@RequestMapping(value="/inquiry/read/{num}")
	public String read(Model model, @PathVariable int num) {
		model.addAttribute("inquiryVO", inquiryService.read(num));

		return "/inquiry/read";
	}


	// 새 글 작성!!!!
	@RequestMapping(value="/inquiry/write", method=RequestMethod.GET)
	public String write(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		try {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");

			if(authInfo != null) {
				String id = authInfo.getId();
				Member member = memberService.detail(id);
				session.setAttribute("member", member);//write에 박수정이라고 적힘

				model.addAttribute("inquiryVO", new InquiryVO());//커멘드객체(write에 CommandName)

				return "/inquiry/write";
				// GET을 처리하는 메서드는 inquiryVO객체를 생성하여 모델에 추가하고, 객체가 없을 때의 예외를 제거			
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인 후 이용가능합니다.'); location.href='/teamProject/login';</script>");
				out.flush();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 새 글 등록!!!!
	@RequestMapping(value="/inquiry/write", method=RequestMethod.POST)
	public String write(/*@Valid*/ InquiryVO inquiryVO, BindingResult bindingResult, HttpSession session) {
		Member member = (Member)session.getAttribute("member");

		inquiryVO.setName(member.getName());
		inquiryVO.setPassword(member.getPassword());

		// 예외처리(if문 등으로 처리하는 방법 말고 스프링에서 제공하는 방법임)
		if(bindingResult.hasErrors()) {
			return "/inquiry/write";
		}
		try {
			inquiryService.write(inquiryVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/inquiry/list";			
		// POST를 처리하는 메서드는 BindingResult객체를 인자로 전달받아 예외상황을 처리
	}

	// 글 수정!!!!
	@RequestMapping(value="/inquiry/edit/{num}", method=RequestMethod.GET)
	public String edit(@PathVariable int num, Model model) {
		InquiryVO inquiryVO = inquiryService.read(num);
		model.addAttribute("inquiryVO", inquiryVO);
		return "/inquiry/edit";
	}

	@RequestMapping(value="/inquiry/edit/{num}", method=RequestMethod.POST)
	public String edit(/*@Valid*/ @ModelAttribute
			InquiryVO inquiryVO, BindingResult result, HttpSession session,
			SessionStatus sessionStatus, Model model, HttpServletResponse response, HttpServletRequest request) {

		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		try {
			if(result.hasErrors()) {
				return "/inquiry/edit";
			} else {
				if(inquiryVO.getPassword().equals(authInfo.getPassword())) {

					inquiryService.edit(inquiryVO);
					sessionStatus.setComplete(); // 세션에 저장된 객체를 제거하는 코드(필수는X)
					return "redirect:/inquiry/list";

				} else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('비밀번호가 맞지 않습니다.'); </script>");
					out.flush();			
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/inquiry/edit";
	}

	// 글 삭제!!!!
	@RequestMapping(value="/inquiry/delete/{num}", method=RequestMethod.GET)
	public String delete(@PathVariable int num, Model model) {
		try {
			model.addAttribute("num", num);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/inquiry/delete";
	}

	@RequestMapping(value="/inquiry/delete", method=RequestMethod.POST)
	public String delete(int num, String password, Model model, HttpServletResponse response, HttpServletRequest request) {
		try {
			int rowCount;
			InquiryVO inquiryVO = new InquiryVO();
			inquiryVO.setNum(num);
			inquiryVO.setPassword(password);

			rowCount = inquiryService.delete(inquiryVO);

			if(rowCount == 0) {
				model.addAttribute("num", num);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('비밀번호를 잘못 입력하셨습니다.');</script>");
				out.flush();
				return "/inquiry/delete";
			} else {
				return "redirect:/inquiry/list";
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/inquiry/list";
	}

	// 새 답글 작성!!!!
	@RequestMapping(value="/inquiry/reply/{num}", method=RequestMethod.GET)
	public String replyWrite(Model model, HttpSession session, @PathVariable int num) {
		try {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			String id = authInfo.getId();
			Member member = memberService.detail(id);
			session.setAttribute("member", member);//write에 박수정이라고 적힘

			InquiryVO inquiryVO = new InquiryVO(); // 새 글 작성 됨
			InquiryVO vo = inquiryService.selectByNum(num); // 저장된 글 불러옴 return값이 vo
			//		System.out.println(vo.getNum());//21

			inquiryVO.setRnum(vo.getRnum());//새글의 rnum에 저장된 글 rnum을 넣음
			inquiryVO.setRstep(vo.getRstep());//0
			inquiryVO.setRlevel(vo.getRlevel());//0

			model.addAttribute("inquiryVO", inquiryVO);//커멘드객체(write에 CommandName)


			inquiryVO.setType(vo.getType());
			System.out.println(inquiryVO.getType());
			session.setAttribute("inquiryVO", inquiryVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/inquiry/reply";
		// GET을 처리하는 메서드는 inquiryVO객체를 생성하여 모델에 추가하고, 객체가 없을 때의 예외를 제거
	}


	// 새 답글 등록!!!!
	@RequestMapping(value="/inquiry/reply/{num}", method=RequestMethod.POST)
	public String replyWrite(/*@Valid*/ InquiryVO inquiryVO, BindingResult bindingResult, HttpSession session) {
		Member member = (Member)session.getAttribute("member");

		inquiryVO.setName(member.getName());
		inquiryVO.setPassword(member.getPassword());

		// 예외처리(if문 등으로 처리하는 방법 말고 스프링에서 제공하는 방법임)
		if(bindingResult.hasErrors()) {
			return "/inquiry/reply";
		}

		try {
			System.out.println(inquiryVO.getRnum());
			inquiryService.replyEdit(inquiryVO);
			inquiryService.replyWrite(inquiryVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/inquiry/list";		
		// POST를 처리하는 메서드는 BindingResult객체를 인자로 전달받아 예외상황을 처리
	}


	@RequestMapping(value="/inquiry")
	public String inquiry() {
		return "/inquiry/faq";
	}
}