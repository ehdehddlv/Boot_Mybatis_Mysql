package com.iu.s1.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BoardRepository;
import com.iu.s1.board.BoardService;
import com.iu.s1.board.BoardVO;
import com.iu.s1.board.notice.noticeFile.NoticeFileRepository;
import com.iu.s1.board.notice.noticeFile.NoticeFileVO;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.FilePathGenerator;
import com.iu.s1.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)	//예외가 발생하면 롤백해줌
public class NoticeService implements BoardService{

	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private NoticeFileRepository noticeFileRepository;
	@Autowired
	private FilePathGenerator pathGenerator;	//파일의 경로를 만들어 주는 애
	@Autowired
	private FileManager fileManager;	//실제 파일을 하드에 저장하는 애
	
	@Value("${board.notice.filePath}")	//value 값을 filePath에 넣음(application.properties)
	private String filePath;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		//파일 경로 저장
		//File file = pathGenerator.getUserResourceLoader(filePath);
		File file = pathGenerator.getUseClassPathResource(filePath);
		//File file = pathGenerator.getUseServletContext(filePath);
		
		int result = noticeRepository.setInsert(boardVO);
		
		for(MultipartFile multipartFile : files) {
			//의미없는 0바이트 파일 없애기
			if(multipartFile.getSize()<=0) {
				continue;
			}
			String fileName = fileManager.saveFileCopy(multipartFile, file);
			NoticeFileVO noticeFileVO = new NoticeFileVO();
			noticeFileVO.setNum(boardVO.getNum());
			noticeFileVO.setFileName(fileName);
			noticeFileVO.setOriName(multipartFile.getOriginalFilename());
			
			result = noticeFileRepository.setInsert(noticeFileVO);
			
			//System.out.println(fileName);
		}
		return result; 
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeRepository.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeRepository.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeRepository.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		long totalCount = noticeRepository.boardCount(pager);
		pager.makePage(totalCount);
		
		return noticeRepository.getSelectList(pager);
	}
	
	
	public NoticeFileVO fileDown(NoticeFileVO noticeFileVO) throws Exception{
		return noticeFileRepository.fileDown(noticeFileVO);
	}

	
}
