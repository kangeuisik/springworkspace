package com.jafa.dataSource;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jafa.AppTest;

public class DataSourceTest extends AppTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() {
		
		try {
			String sql = "select sysdate as result from dual";
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs =  pstmt.executeQuery();
		rs.next();
		Date date = rs.getDate("result");
		System.out.println(date);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void test2() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="select sysdate as result from dual";
		Date now = jdbcTemplate.queryForObject(sql, Date.class);
		System.out.println("스프링 : "+now);
	}
}
