package com.iu.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.s1.interceptor.CustomInterceptor;
import com.iu.s1.interceptor.CustomInterceptor2;
import com.iu.s1.interceptor.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	//springBoot 2.0 이후부터는 Deprecated (사용하지 않는 걸 권장)
	//WebMvcConfigurerAdapter
	
	//springBoot 2.0 이후는 다음을 사용
	//WebMvcConfigurer
	
	@Autowired
	private CustomInterceptor customInterceptor;
	@Autowired
	private CustomInterceptor2 customInterceptor2;
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		
		
		//메서드 체이닝 방식
		
		//적용할 Interceptor 등록
		registry.addInterceptor(customInterceptor)
		//Interceptor를 사용할 URL 등록
		.addPathPatterns("/notice/noticeWrite")
		.addPathPatterns("/notice/noticeUpdate")
		.addPathPatterns("/notice/noticeDelete");
		
		//Interceptor에서 제외할 URL 등록
//		.excludePathPatterns("/notice/noticeList")
//		.excludePathPatterns("/notice/noticeSelect")
//		.excludePathPatterns("/qna/qnaList");
		
		
		//-------------------------
		
		registry.addInterceptor(writerCheckInterceptor)
		.addPathPatterns("/qna/qnaUpdate")
		.addPathPatterns("/qna/qnaDelete");
		
		
		//--------------------------------------
		
		registry.addInterceptor(customInterceptor2)
//		.addPathPatterns("/qna/qnaSelect")
//		.addPathPatterns("/qna/qnaUpdate")
//		.addPathPatterns("/qna/qnaWrite")
//		.addPathPatterns("/qna/qnaDelete")
//		.addPathPatterns("/qna/qnaReply")
//		.addPathPatterns("/qna/qnaReplyUpdate")
		.addPathPatterns("/qna/*")
		//제외
		.excludePathPatterns("/qna/qnaList");
		
		
		
		
		
		
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
	
	
}
