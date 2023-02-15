package com.jafa.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;

import com.jafa.domain.MemberVO;

public class MemberDaoImpl implements MemberDao {

	SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public MemberVO findByMno(@Param("mno") Long memberNo) {
		MemberVO vo = sessionTemplate.selectOne("com.jafa.dao.test.MemberDao.findByMno",memberNo);
		return vo;
	}
}
