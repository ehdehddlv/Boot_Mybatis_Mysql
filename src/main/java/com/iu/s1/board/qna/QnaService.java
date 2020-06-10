package com.iu.s1.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BoardService;
import com.iu.s1.board.BoardVO;
import com.iu.s1.board.qna.qnaFile.QnaFileRepository;
import com.iu.s1.board.qna.qnaFile.QnaFileVO;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.FilePathGenerator;
import com.iu.s1.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class QnaService implements BoardService{

	@Autowired
	private QnaRepository qnaRepository;
	@Autowired
	private QnaFileRepository qnaFileRepository;
	@Autowired
	private FilePathGenerator pathGenerator;
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.qna.filePath}")
	private String filePath;
	
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception{
		
		File file = pathGenerator.getUserResourceLoader(filePath);
		
		int result = qnaRepository.setInsert(boardVO);
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.getSize()<=0) {
				continue;
			}
			String fileName = fileManager.saveTransfer(multipartFile, file);
			QnaFileVO qnaFileVO = new QnaFileVO();
			qnaFileVO.setNum(boardVO.getNum());
			qnaFileVO.setFileName(fileName);
			qnaFileVO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaFileRepository.setInsert(qnaFileVO);
			
			System.out.println(file.getAbsolutePath());
		}
		
		return result; 
	}
	
	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception{
		pager.makeRow();
		long totalCount = qnaRepository.boardCount(pager);
		pager.makePage(totalCount);
		
		return qnaRepository.getSelectList(pager);
	}
	
	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception{
		return qnaRepository.getSelectOne(boardVO);
	}
	
	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		return qnaRepository.setUpdate(boardVO);
	}
	
	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		return qnaRepository.setDelete(boardVO);
	}
	
	
	public int boardReply(BoardVO boardVO) throws Exception{
		int result = qnaRepository.boardReplyUpdate(boardVO);
		result = qnaRepository.boardReply(boardVO);
		return result;
	}
	
}
