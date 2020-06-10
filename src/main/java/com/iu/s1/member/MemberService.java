package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return memberRepository.memberLogin(memberVO);
	}
	
	public int memberJoin(MemberVO memberVO) throws Exception{
		return memberRepository.memberJoin(memberVO);
	}
	
	//검증 메서드 추가
	public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean result = false;	//에러가 없음
		
		//1. 기본 Annotataion제공 검증
		//result = bindingResult.hasErrors(); 두개 같은 코드
//		if(bindingResult.hasErrors()) {
//			result = true;
//		}
		
		//2. pw 일치 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
			bindingResult.rejectValue("pwCheck", "memberVO.password.notSame");
			result = true;
		}
			
		//3. id 중복 검증
		//DB에서 조회
		memberVO = memberRepository.memberIdCheck(memberVO);
		if(memberVO!=null) {
			bindingResult.rejectValue("id", "memberVO.id.same");
			result = true;
		}
		
		return result;
	}
	
}
