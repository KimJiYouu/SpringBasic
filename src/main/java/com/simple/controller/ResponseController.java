package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	@RequestMapping("/res_ex01")
	public void ex01() {
		
	}
	
	//model전달자
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		model.addAttribute("name", "charlie");
		model.addAttribute("date", new Date());
		return "response/ex02";
	}
	
	//ModelAndView - 데이터와 화면 정보를 동시에 저장하는 객체
	@RequestMapping("/ex03")
	public ModelAndView ex03(ModelAndView mv) {
		//ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date()); //데이터
		mv.setViewName("response/ex03"); //화면정보
		
		return mv;
	}
	
	//@ModelAttribute(화면에서 넘어오는 키값)
	@RequestMapping("/ex04")
	public String ex04(@ModelAttribute("id") String id) {
		
		System.out.println("넘어온 값: " + id);
		
		return "response/ex04";
	}
	
	//ModelAttribute 객체타입 vo로 받아서 xxx이름으로 변경해서 화면으로 전달
	@RequestMapping("/ex05")
	public String ex05(@ModelAttribute("xxx") ReqVO vo) { //xxx : 넘어갈 화면에서 쓰일 변수
		
		System.out.println(vo.toString());
		return "response/ex05";
	}
	
	/////////////////////////////////////////////////////////
	/////리디렉션과 리디렉션어트리뷰트/////
	
	//화면처리
	@RequestMapping("/join")
	public String join() {
		return "response/join";
	}
	
	//폼요청
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST)
	public String joinForm(ReqVO vo, RedirectAttributes ra) {
		//가입처리 완료 후 홈화면이동
		
		//리다이렉트 시에 사용하며 1회성 데이터를 화면에 전달해줄 수 있음
		//리다이렉트 시에 model은 사용할 수 없음
		ra.addFlashAttribute("msg", "정상처리되었습니다"); //새로고침하면 사라짐
		
		return "redirect:/"; //redirect:/절대경로
		
	}
	
	///실습///
	@RequestMapping("/res_quiz01")
	public String res_quiz01() {
		return "response/res_quiz01";
	}
	
	//방법1
//	@RequestMapping(value = "/res_login", method = RequestMethod.POST)
//	public String res_login(@ModelAttribute("vo") Quiz01VO vo, RedirectAttributes ra) {
//		if(vo.getId().equals("kim12") && vo.getPw().equals("1234")) {
//			return "response/res_quiz02";
//		} else {
//			
//			ra.addFlashAttribute("msg", "다시 로그인하세요");
//			return "redirect:/response/res_quiz01";
//		}
//	}
	
	
	
	//방법2
	@RequestMapping("/res_login")
	public String res_login(@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							Model model, RedirectAttributes ra) {
		
		if(id.equals("kim12") && pw.equals("1234")) {
			model.addAttribute("id", id); //forward는 Model 사용
			return "response/res_quiz02";
		} else {
			ra.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			return "redirect:/response/res_quiz01"; //가지고 나갈 데이터가 없을 시 리다이렉트 사용
		}
		
	}
}

