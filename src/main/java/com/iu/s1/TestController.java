package com.iu.s1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iu.s1.util.Pager;

@Controller
public class TestController {

	@GetMapping("/test/select/{num}")
	public void test(@PathVariable(value = "num") String num) {
		System.out.println("num : "+num);
	}
	
	
	
	@GetMapping("/test/select/{num}/{name}")
	public void test3(@PathVariable String num, @PathVariable String name) {
		System.out.println("num : "+num);
		System.out.println("name : "+name);
	}
	
	//{이름}과 Path의 변수명과 이름이 같으면 value 안써도 됌
	@GetMapping("/test/{curPage}/{kind}/{search}/list")
	public void test2(Pager pager) {
		System.out.println("curPage : "+pager.getCurPage());
		System.out.println("kind : "+pager.getKind());
		System.out.println("search : "+pager.getSearch());
	}
	//@PathVariable int curPage, @PathVariable String kind, @PathVariable String search
	
}
