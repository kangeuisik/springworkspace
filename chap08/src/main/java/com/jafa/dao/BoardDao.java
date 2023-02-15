package com.jafa.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jafa.domain.BoardVO;
@Repository
public class BoardDao {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public BoardDao(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	RowMapper<BoardVO> boardMapper = (rs, rowNum) -> {
		return BoardVO.builder().bno(rs.getLong("bno"))
				.title(rs.getString("title"))
				.content(rs.getString("content"))
				.writer(rs.getString("writer"))
				.writeDate(rs.getDate("writeDate")).build();
			};
			
	//게시물 리스트
	public List<BoardVO> list(){
		return jdbcTemplate.query("select * from board_t",boardMapper);	
	}
	public BoardVO detail(Long bno) {
		List<BoardVO> list = jdbcTemplate.query("select * from board_t where bno=?",boardMapper,bno);	
		if(list.isEmpty()) {
			throw new RuntimeException("찾는게시물 없음");
		}
		return list.get(0);
	}
	//글쓰기
	public void insert(BoardVO vo) {
		String sql="insert into board_t(bno,title,content,writer) values(bno_seq.nextval,?,?,?)";
		jdbcTemplate.update(sql,vo.getTitle(),vo.getContent(),vo.getWriter());
	}
	public Long insertKeyHolder(BoardVO vo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();// 자동으로 생성된 키값을 구하는 객체
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into board_t(bno,title,content,writer) values(bno_seq.nextval,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql,new String[] {"BNO"});
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getWriter());
				return pstmt;
			}
		},keyHolder);
		Long key =keyHolder.getKey().longValue();
		vo.setBno(key);
		return key;
	}
	//삭제
	public void delete(Long bno) {
		String sql="delete from board_t where bno=?";
		jdbcTemplate.update(sql,bno);
	}
	//
	public BoardVO getByBno(Long bno) {
		BoardVO vo = null;
		String sql="delete from board_t where bno=?";
		try {
			vo = jdbcTemplate.queryForObject(sql, boardMapper ,bno);			
		} catch (EmptyResultDataAccessException e) {
			System.out.println("찾는게시물 없음");
		}
		return vo;
	}
	
	//게시글 총갯수
	public int totalCount() {
		String sql="select count(*) from board_t";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
}
