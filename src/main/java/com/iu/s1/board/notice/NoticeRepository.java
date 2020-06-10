package com.iu.s1.board.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.iu.s1.board.BoardRepository;

@Repository //생략가능
@Mapper		//interface 이기 때문에 넣어줘야함
public interface NoticeRepository extends BoardRepository {

}
