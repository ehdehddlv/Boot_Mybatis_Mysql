package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.s1.board.BoardVO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**/")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("path", "Write");
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardVO boardVO, MultipartFile[] files, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardVO, files);
		rd.addFlashAttribute("result", result);
		
		mv.setViewName("redirect:./qnaList");
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getSelectList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> ar = qnaService.getSelectList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getSelectOne(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView boardReply(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("num", num);
		mv.setViewName("board/boardReply");
		
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView boardReply(QnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.boardReply(qnaVO);
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.setViewName("board/boardList");
		}
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getSelectOne(boardVO);
		mv.addObject("vo", boardVO);
		mv.addObject("path", "Update");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(boardVO);
		mv.setViewName("redirect:./qnaList");
		rd.addFlashAttribute("result", result);
		
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(BoardVO boardVO, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(boardVO);
		mv.setViewName("redirect:./qnaList");
		rd.addFlashAttribute("result", result);
		return mv;
	}
	
	
}
