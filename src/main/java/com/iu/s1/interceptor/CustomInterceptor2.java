package com.iu.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberVO;

@Component
public class CustomInterceptor2 extends HandlerInterceptorAdapter{

	//회원인지 아닌지 구별
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object obj = request.getSession().getAttribute("member");
		if(obj != null) {
			return true;
		}else {
			response.sendRedirect("../message/messageResult?result=Login Please&path=/member/memberLogin");
			return false;
		}
		
	}
	
	
	
	
}
