package com.iu.s1.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.iu.s1.board.BoardRepository;
import com.iu.s1.board.BoardVO;

@Mapper
public interface QnaRepository extends BoardRepository{
	
	public int boardReply(BoardVO boardVO) throws Exception;
	
	public int boardReplyUpdate(BoardVO boardVO) throws Exception;
}
