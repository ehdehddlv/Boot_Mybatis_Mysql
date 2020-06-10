package com.iu.s1;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {
	
	//null포인터 예외 발생하면 모든게 다 여기서 받음
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView error1() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	//여긴 멤버 포멧 예외만 다 받음
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView error2() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	//얘는 모든 예외 다 받음
	@ExceptionHandler(Exception.class)
	public ModelAndView error3() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		return mv;
	}
	
	
	
	
}
