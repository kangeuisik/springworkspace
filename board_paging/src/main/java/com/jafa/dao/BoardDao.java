package com.jafa.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;

@Repository
public class BoardDao {
	
	JdbcTemplate jdbcTemplate;
	//데이터 jdbcTemplate에 주입 
	@Autowired
	public BoardDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	RowMapper<BoardVO> rowMapper = (rs, rowNum) -> BoardVO.builder() 
				.bno(rs.getLong("bno"))
				.title(rs.getString("title"))
				.content(rs.getString("content"))
				.writer(rs.getString("writer"))
				.writeDate(rs.getDate("writeDate"))
				.build();
		
	
	//게시물 리스트
	public List<BoardVO> list(Criteria criteria){
		String sql = "SELECT ROWNUM, BNO, TITLE, CONTENT, WRITER, WRITEDATE";
		sql+=" FROM(SELECT /*+INDEX_DESC(BOARD_PAGING PK_BOARD)*/ ";
		sql+=" ROWNUM AS RN, BNO, TITLE, CONTENT, WRITER, WRITEDATE ";
		sql+=" FROM BOARD_PAGING WHERE ROWNUM<=?) WHERE RN > ?";
		
		int maxRow = criteria.getPageNum()*criteria.getAmount();
		int minRow = (criteria.getPageNum()-1)*criteria.getAmount();
		
		return jdbcTemplate.query(sql, (RowMapper<BoardVO>) rowMapper,maxRow,minRow);
		}
	//게시물 갯수 
	public int totalCount() {
		return jdbcTemplate.queryForObject("select count(*) from board_paging", Integer.class);
	}
	//게시물 상세
	public BoardVO detail(Long bno) {
		String sql = "select * from board_paging where bno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper,bno);
	}
	//게시물 조회
	
}
