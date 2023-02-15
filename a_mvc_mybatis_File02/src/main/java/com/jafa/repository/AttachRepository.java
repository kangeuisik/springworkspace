package com.jafa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jafa.domain.AttachVO;

public interface AttachRepository {
	//첨부파일이 여러개라 리스트로..
	void save(@Param("attachList") List<AttachVO> attachList);

	List<AttachVO> list(Long bno);

	
	AttachVO get(Long attachNo);

	void remove(Long attachNo);
}
