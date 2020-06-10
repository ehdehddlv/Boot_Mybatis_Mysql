package com.iu.s1.board.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.s1.board.BoardVO;
import com.iu.s1.board.notice.noticeFile.NoticeFileVO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/notice/**/")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardVO boardVO, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardVO);
		mv.setViewName("redirect:./noticeList");
		rd.addFlashAttribute("result", result);
		return mv;
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(ModelAndView mv, BoardVO boardVO) throws Exception{
		boardVO = noticeService.getSelectOne(boardVO);
		mv.addObject("vo", boardVO);
		mv.addObject("path", "Update");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setUpdate(boardVO);
		mv.setViewName("redirect:./noticeList");
		rd.addFlashAttribute("result", result);
		
		return mv;
	}
	
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("path", "Write");
		mv.addObject("boardVO", new BoardVO());
		return mv; 
	}
	
//	@PostMapping("noticeWrite")
//	public String setInsert(BoardVO boardVO, MultipartFile[] files, RedirectAttributes rd) throws Exception{
//		//RedirectAttributes = 리다이렉트 방식으로 데이터를 넣을 수 있음
//		int result = noticeService.setInsert(boardVO, files);
//		rd.addFlashAttribute("result", result);
//		return "redirect:./noticeList";
//	}
	
	//SpringForm 처리 방식
	@PostMapping("noticeWrite")					//내가 검증하려고 하는 객체 바로 뒤에 BindingResult 선언 해야함
	public ModelAndView setInsert(@Valid BoardVO boardVO, BindingResult bindingResult, MultipartFile[] files, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			
			mv.setViewName("board/boardWrite");
			mv.addObject("path", "Write");
		}else {
			int result = noticeService.setInsert(boardVO, files);
			rd.addFlashAttribute("result", result);
			mv.setViewName("redirect:./noticeList");
		}
		
		return mv;
	}
	
	
	@GetMapping("noticeList")
	public ModelAndView getSelectList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = noticeService.getSelectList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getSelectOne(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(NoticeFileVO noticeFileVO) throws Exception{
		ModelAndView mv = new ModelAndView();

		noticeFileVO = noticeService.fileDown(noticeFileVO);
		
		mv.addObject("fileVO", noticeFileVO);
		mv.addObject("path", "upload/notice/");
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	//예외 처리 메서드
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView error() {
		ModelAndView mv = new ModelAndView();
		
		
		return mv;
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public ModelAndView error2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView error3() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		
		return mv;
	}
	
	
}
