package com.jafa.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.jafa.domain.BookVO;

public interface BookRepository {
	
	@Insert("insert into book_mybatis values(bookId_seq_mybatis.nextval, #{title},#{writer})")
	@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
	void addBook(BookVO vo);
}
