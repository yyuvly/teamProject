package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import domain.GoodsVO;
import service.CookieRegisterService;
import service.GoodsService;

@Controller
public class GoodsController {

	private GoodsService goodsService;
	private CookieRegisterService cookieRegisterService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setCookieRegisterService(CookieRegisterService cookieRegisterService) {
		this.cookieRegisterService = cookieRegisterService;
	}
	
	@RequestMapping(value="/goods/regist", method=RequestMethod.GET)
	public String regist(Model model) {
		model.addAttribute("goodsVO", new GoodsVO());
		return "/goods/regist";
	}

	@RequestMapping(value="/goods/regist", method=RequestMethod.POST)
	public String regist(GoodsVO goodsVO, BindingResult bindingResult) throws IOException {
		if(bindingResult.hasErrors()) {
			return "/goods/regist";
		}
		List<MultipartFile> descriptFile=goodsVO.getDescriptFile();
		List<String> files=new ArrayList<String>();
		if(descriptFile!=null&&descriptFile.size()>0) {
			for(MultipartFile multipartFile:descriptFile) {
				//				유니크 유저 아이디
				String uuid=UUID.randomUUID().toString().replaceAll("-", "");
				//				커런트 타임 밀리
				String ctm=Long.toString(System.currentTimeMillis());
				//				오리지널 파일 네임
				String ofn=multipartFile.getOriginalFilename();
				//				파일 네임 익스텐션 (확장자)
				String fne=ofn.substring(ofn.lastIndexOf("."));
				//				stored 파일 네임
				String sfn=uuid+ctm+fne;
//	**** 자신의 workspace 경로를 써주세요		파일업로드시 저장 경로
				String fsp="F:/maven_workspace/teamProjectFinal/src/main/webapp/images/goods/";

				byte[] fileData=multipartFile.getBytes();
				FileOutputStream fos=new FileOutputStream(fsp+sfn);
				fos.write(fileData);
				fos.close();
				files.add(sfn);
			}
			String tdf=files.toString().substring(1, files.toString().length()-1);
			goodsVO.setImg(tdf.substring(0, 49));
			goodsVO.setDescript(tdf);
			goodsService.regist(goodsVO);
		}
		return "redirect:/goods/list";
	}

	// 상품 리스트 보는 경로
	@RequestMapping(value="/goods/list")
	public String list(Model model) {
		try {
			model.addAttribute("goodsList", goodsService.list());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/goods/list";
	}
	// 상품 디테일 보는 경로
	@RequestMapping(value="/goods/detail/{num}")
	public String detail(Model model, @PathVariable int num, HttpSession session) {
		try {
		GoodsVO tmp = goodsService.detail(num);
		session.setAttribute("num", tmp.getNum());
		
		model.addAttribute("goodsVO",goodsService.detail(num));
		model.addAttribute("Goods", new GoodsVO());
		GoodsVO goodsVO = goodsService.divide(num);
		
		String tempArr=goodsVO.getDescript().substring(51, goodsVO.getDescript().length());
		String[] desarr=tempArr.split(", ");
		model.addAttribute("goodsVOarr", desarr);
		return "/goods/detail";
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;
	}
	
	@RequestMapping(value="/goods/edit/{num}", method=RequestMethod.GET)
	public String edit(@PathVariable int num, Model model) {
		GoodsVO goodsVO=goodsService.detail(num);
		model.addAttribute("goodsVO", goodsVO);
		return "/goods/edit";
	}
	@RequestMapping(value="/goods/edit/{num}", method=RequestMethod.POST)
	public String edit(@Valid GoodsVO goodsVO, BindingResult result) throws IOException {
		if(result.hasErrors()) {
			return "/goods/edit";
		}
		if(!goodsVO.getDescriptFile().get(0).getOriginalFilename().isEmpty()) {
			List<MultipartFile> descriptFile=goodsVO.getDescriptFile();
			List<String> files=new ArrayList<String>();
			if(descriptFile!=null&&descriptFile.size()>0) {
				for(MultipartFile multipartFile:descriptFile) {
					String uuid=UUID.randomUUID().toString().replaceAll("-", "");
					String ctm=Long.toString(System.currentTimeMillis());
					String ofn=multipartFile.getOriginalFilename();
					String fne=ofn.substring(ofn.lastIndexOf("."));
					String sfn=uuid+ctm+fne;
					System.out.println(sfn);
//		**** 자신의 workspace 경로를 써주세요		물품 수정할때도 같은 경로.					
					String fsp="F:/maven_workspace/teamProjectFinal/src/main/webapp/images/goods/";
					byte[] fileData=multipartFile.getBytes();
					FileOutputStream fos=new FileOutputStream(fsp+sfn);
					fos.write(fileData);
					fos.close();
					files.add(sfn);
				}
			}
			String tdf=files.toString().substring(1, files.toString().length()-1);
			goodsVO.setImg(tdf.substring(0, 49));
			goodsVO.setDescript(tdf);
		}
		goodsService.edit(goodsVO);
		return "redirect:/goods/list";
	}
	@RequestMapping(value="/goods/delete/{num}", method=RequestMethod.GET)
	public String delete(@PathVariable int num, Model model) {
		model.addAttribute("num", num);
		return "/goods/delete";
	}
	@RequestMapping(value="/goods/delete", method=RequestMethod.POST)
	public String delete(int num, String item, Model model) {
		int rowCount;
		GoodsVO goodsVO=new GoodsVO();
		goodsVO.setNum(num);
		rowCount=goodsService.delete(goodsVO);
		if(rowCount==0) {
			model.addAttribute("num", num);
			model.addAttribute("msg", "품목명이 잘못되었다");
			return "/goods/delete";
		}
		else {
			return "redirect:/goods/list";
		}
	}
	
	@RequestMapping(value="/goods/detail/cart", method=RequestMethod.POST)
	public String registerCart(@ModelAttribute("Goods")GoodsVO regReq, HttpServletResponse response, HttpSession session, Model model) {
			try {
			int num = (Integer)session.getAttribute("num");
			regReq.setNum(num);
		
			Cookie cookie = cookieRegisterService.regist(regReq);
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath("/");
			response.addCookie(cookie);
		
			return "redirect:"+"/goods/detail"+"/"+num;
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
	}
}
