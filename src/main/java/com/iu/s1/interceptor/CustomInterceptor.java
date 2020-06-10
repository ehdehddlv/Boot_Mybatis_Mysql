package com.iu.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberVO;

@Component
public class CustomInterceptor extends HandlerInterceptorAdapter{

	//관리자인지 아닌지 구별
	//Controller 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("contoller 진입 전");
		//return true 라면 Controller 전송
		//return false 라면 Controller 진입불가
		
		boolean check = false;
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO != null && memberVO.getId().equals("admin")) {
			check = true;
		} else {
			response.sendRedirect("../message/messageResult?result=Not Admin&path=../");
			//RequestDispatcher view = request.getRequestDispatcher("/");
			//view.forward(request, response);
		}
		
		
		return check;
	}
	
	//Controller 진입 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("controller 진입 후");
	}
	
	//JSP 렌더링 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("JSP 렌더링 후");
	}
	
	//비동기 요청시 PostHandle과 AfterCompletion 수행하지않고 이 메서드를 실행
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	
}
