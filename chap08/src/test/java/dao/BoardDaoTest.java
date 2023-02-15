package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.config.RootConfig;
import com.jafa.config.ServletConfig;
import com.jafa.dao.BoardDao;
import com.jafa.domain.BoardVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,ServletConfig.class})
@WebAppConfiguration
public class BoardDaoTest {
	@Autowired
	BoardDao boardDao;
	
	@Test
	@Ignore
	public void testList() {
		List<BoardVO> list = boardDao.list();
		assertEquals(4, list.size());

	}
	@Test
	@Ignore
	public void testDetail() {
		BoardVO detail = boardDao.detail(1L);
		assertEquals("제목입니다.01", detail.getTitle());
		assertEquals("내용입니다.01", detail.getContent());
		assertEquals("관리자", detail.getWriter());
		System.out.println(detail);
	}
	
	@Test
	@Ignore
	public void testInsert() {
		BoardVO vo =BoardVO.builder().title("제목:글쓰기테스트")
				.content("내용:테스트")
				.writer("운영자").build();
		boardDao.insert(vo);
	}
	@Test
	@Ignore
	public void delTest() {
		boardDao.delete(1L);
	}
	
	@Test
	@Ignore
	public void countBoard() {
		int totalCount = boardDao.totalCount();
		System.out.println(totalCount);
	}
	
	@Test
	@Ignore
	public void getBno() {
		BoardVO vo = boardDao.getByBno(3L);
		System.out.println(vo);
	}
	@Test
	public void testkeyHolder() {
		BoardVO vo =BoardVO.builder().title("제목:글쓰기테스트 자동생성값")
				.content("내용:테스트껄껄")
				.writer("운영자님").build();
		Long key = boardDao.insertKeyHolder(vo);
		System.out.println(key);
	}
}
