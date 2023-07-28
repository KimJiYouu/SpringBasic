package com.simple.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request") //각 메서드의 공통 분모
public class RequestController { //테이블 당, 주제별로 하나씩 필요
	
	@RequestMapping("/req_ex01") //클래스 위에 선언된 어노테이션 경로와 병합됨 request/req_ex01
	public void ex01() {
	}
	
//	@RequestMapping("/req_ex01") //클래스 위에 선언된 어노테이션 경로와 병합됨 request/req_ex01
//	public String ex01() {
//		return "request/req_ex01";
//	}
	
	//@RequestMapping(value = "/basic1", method = RequestMethod.GET) //기본 속성이 value, get요청만 허용
	@GetMapping("/basic1") //get요청만 허용하는 어노테이션
	public String basic1() {
		System.out.println("baisc요청");
		return "request/basic1";
	}
	
	
	//@RequestMapping(value = "/basic2", method = RequestMethod.POST) //a링크는 get방식이므로 post방식만 받는 RequestMapping 적용불가
	@PostMapping("/basic2") //post요청만 허용하는 어노테이션
	public void basic2() {
		System.out.println("basic2 요청");
	}
	
	@RequestMapping("/basic3")
	public void basic3() {
		System.out.println("basic3요청");
	}
	
	//////////////////////파라미터 값 받기///////////////////////
	@RequestMapping("/req_ex02")
	public String ex02() {
		return "request/req_ex02";
	}
	
	//전통적인 방법
//	@RequestMapping("/param1") // submit할 떄 form 태그 액션값
//	public String param1(HttpServletRequest request) {
//		
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		String[] inter = request.getParameterValues("inter");
//		System.out.println(name);
//		return "request/result"; //result페이지로 이동
//	}
	
	
	//@RequestParam(name값) - 반드시 필수로 전달이 되어야 함
	//required = false 는 반드시 필수가 아님
	//defaultValue 값이 없을 때 기본값
//	@RequestMapping("/param1") // submit할 떄 form 태그 액션값
//	public String param1(@RequestParam("name") String xxx, 
//						 @RequestParam(value = "age", required = false, defaultValue = "0") int yyy,
//						 @RequestParam(value = "inter", required = false, defaultValue = "") ArrayList<String> zzz) {
//		
//		System.out.println(xxx);
//		System.out.println(yyy);
//		System.out.println(zzz.toString());
//		
//	
//		return "request/result"; //result페이지로 이동
//	}
	
	//커맨드객체 이용하는 방법
	@RequestMapping("/param1") // submit할 떄 form 태그 액션값
	public String param1(ReqVO vo) {
		
		System.out.println(vo.toString());
		
		return "request/result"; //result페이지로 이동
	}
	
	////////실습//////////
	
	//화면띄우기//
	@RequestMapping("/req_quiz01")
	public String quiz01() {
		return "/request/req_quiz01";
	}
	
	//파라미터 받기//
	//방법1
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("abc123") && pw.equals("xxx123")) {
			return "request/req_quiz01_ok";
		} else {
			return "request/req_quiz01_no";
		}
		
	}
	
	//방법2
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam(value = "id") String id,
//						@RequestParam(value = "pw") String pw) {
//		
//		if(id.equals("abc123") && pw.equals("xxx123")) {
//			return "request/req_quiz01_ok";
//		} else {
//			return "request/req_quiz01_no";
//		}
//	}
	
	//방법3
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(Quiz01VO vo) {
//		String id = vo.getId();
//		String pw = vo.getPw();
//		
//		if(id.equals("abc123") && pw.equals("xxx123")) {
//			return "request/req_quiz01_ok";
//		} else {
//			return "request/req_quiz01_no";
//		}
//		
//	}
	
	
	
	
	
	
	
}  
