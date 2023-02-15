package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;

public interface BoardRepository {

	List<BoardVO> list(Criteria criteria);

	BoardVO detail(Long bno);

}
