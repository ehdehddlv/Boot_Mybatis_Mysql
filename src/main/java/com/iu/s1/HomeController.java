package com.iu.s1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.FilePathGenerator;

@Controller
public class HomeController {

	@Autowired
	private FilePathGenerator pathGenerator;
	
	@GetMapping("/message/messageResult")
	public ModelAndView message(String result, String path) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("result", result);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("/")
	public String home(Model model) throws Exception{
		pathGenerator.getUserResourceLoader("upload");
		model.addAttribute("name", "iu");
		model.addAttribute("phone", "01012341234");
		return "index";
	}
}
