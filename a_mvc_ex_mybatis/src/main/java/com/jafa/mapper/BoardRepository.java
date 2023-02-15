package com.jafa.mapper;

import org.apache.ibatis.annotations.Select;

import com.jafa.domain.BoardVO;

public interface BoardRepository {
	@Select("select * from board_mybatis where bno=#{bno}")
	BoardVO findByBno(Long bno);
}
