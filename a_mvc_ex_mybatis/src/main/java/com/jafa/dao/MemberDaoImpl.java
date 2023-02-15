package com.jafa.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.jafa.domain.BoardVO;
import com.jafa.domain.MemberVO;

import lombok.AllArgsConstructor;
@Repository
@AllArgsConstructor
public class MemberDaoImpl implements MemberDao {

	SqlSessionTemplate sessionTemplate;
	
	@Override
	public MemberVO findByMno(Long mno) {
		
		return sessionTemplate.selectOne("com.jafa.dao.MemberDao.findByMno",mno);
	}

}
