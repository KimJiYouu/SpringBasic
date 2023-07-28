package com.simple.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/quiz01")
	public void quiz01() {
	
	}
	
	@RequestMapping("/form01")
	public String form01(@ModelAttribute("year") String year,
						 @ModelAttribute("month") String month,
						 @ModelAttribute("day") String day, Model model) {
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		return "quiz/quiz01_ok";
	}
	
	@RequestMapping("/quiz02")
	public void quiz02() {
		
	}
	
	@RequestMapping("/join")
	public String join(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz03")
	public void quiz03() {
		
	}
	
	@RequestMapping("/join2")
	public String join2(HttpServletRequest request, Model model, RedirectAttributes ra) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw_check = request.getParameter("pw_check");
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check)) {
			ra.addFlashAttribute("msg", "비밀번호를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else {
			model.addAttribute("id", id);
			return "quiz/quiz03_ok";
		}
		
		
	}

}
