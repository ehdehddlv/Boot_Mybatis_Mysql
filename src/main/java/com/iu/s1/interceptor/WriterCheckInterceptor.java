package com.iu.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.board.BoardVO;
import com.iu.s1.board.notice.NoticeRepository;
import com.iu.s1.board.qna.QnaRepository;
import com.iu.s1.member.MemberVO;

@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	QnaRepository qnaRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
			
			int num = Integer.parseInt(request.getParameter("num"));
			BoardVO boardVO = new BoardVO();
			boardVO.setNum(num);
			boardVO = qnaRepository.getSelectOne(boardVO);
			
			if(memberVO != null && boardVO.getWriter().equals(memberVO.getId())) {
				return true;
			}else {
				response.sendRedirect("../message/messageResult?result=Not Equal Member&path=../");
				return false;
			}
		} else {
			return true;
		}
		
		
		
		
	}
	
}
