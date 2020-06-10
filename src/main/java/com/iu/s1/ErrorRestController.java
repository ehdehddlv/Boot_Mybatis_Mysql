package com.iu.s1;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class ErrorRestController {

	//메세지 전송
	@ExceptionHandler(NullPointerException.class)
	public String error1() {
		
		return "Error";
	}
	
}
