package com.iu.s1.board.qna.qnaFile;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface QnaFileRepository {

	public int setInsert(QnaFileVO qnaFileVO) throws Exception;
}
