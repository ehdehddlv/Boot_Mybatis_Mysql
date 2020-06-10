package com.iu.s1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.PastOrPresent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**/")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberLogin")
	public void memberLogin() throws Exception{
		
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.memberLogin(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}
		
		return mv;
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		mv.addObject("memberVO", new MemberVO());
		
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			//검증 안되면 바로 회원가입 폼
			mv.setViewName("member/memberJoin");
		}else {
			//검증 완료 후에 memberError가서 나머지 Custom 검증으로 가서 결과 리턴
			boolean resultError = memberService.memberError(memberVO, bindingResult);
			
			if(resultError) {
				//에러
				mv.setViewName("member/memberJoin");
			}else {
				int result = memberService.memberJoin(memberVO);
				mv.setViewName("redirect:../");
			}
		}
		
		
		
		
//		if(bindingResult.hasErrors()) {
//			mv.setViewName("member/memberJoin");
//		}else {
//			int result = memberService.memberJoin(memberVO);
//			
//			if(result>0) {
//				mv.setViewName("redirect:../");
//			}
//		}
		
		return mv;
	}
	
}
