package example01;



import static org.junit.Assert.*;

import org.junit.Test;

import com.jafa.domain.BoardVO;

public class BoardVOTest {
	@Test
	public void test() {
		BoardVO vo = null;
		assertNull(vo);
	}

	@Test
	public void test2() {
		BoardVO vo = new BoardVO();
		assertNotNull(vo);
	}
	@Test
	public void test3() {
		int a = 10;
		int b = 20;
		assertEquals(30, a+b);
	
	}
	@Test
	public void test4() {
		BoardVO vo = BoardVO
				.builder().content("내용입니다").build();
		
		assertNotNull(vo);
		assertNull(vo.getTitle());
		assertEquals("내용입니다", vo.getContent());
	}
	@Test
	public void test5() {
		String str1 = "홍길동";
		String str2 = new String("홍길동");
		assertEquals(str1, str2);
		assertNotSame(str1, str2); //참조값
	}
	@Test
	public void test6() {
		String str1 = "홍길동";
		String str2 = "홍길동";
		assertEquals(str1,str2);
		assertSame(str1, str2);
	}

}
