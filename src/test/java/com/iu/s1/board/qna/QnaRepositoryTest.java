package com.iu.s1.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaRepositoryTest {

	@Autowired
	private QnaRepository qnaRepository;
	
	@Test
	void setInsertTest() throws Exception{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("title1");
		qnaVO.setWriter("writer1");
		qnaVO.setContents("contents1");
		qnaVO.setStep(0);
		qnaVO.setDepth(0);
		int result = qnaRepository.setInsert(qnaVO);
		
		assertEquals(1, result);
	}

}
