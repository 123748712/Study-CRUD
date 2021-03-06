package kr.or.board.mapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.board.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:config/spring/root-context.xml")
@Slf4j
public class BoardMapperTest {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	@Disabled
	public void selectTest() {
		BoardVO boardVO = boardMapper.selectBoard(12);
		
		log.info("boardVO : " + boardVO.toString());
		
		Assertions.assertEquals(12, boardVO.getBoardNo());
	}
	
	@Test
	@Disabled
	public void deleteTest() {
		Assertions.assertEquals(1, boardMapper.deleteBoard(5));
	}
	
	@Test
	@Disabled
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setBoardTitle("title수정");
		vo.setBoardWriter("writer수정");
		vo.setBoardContent("content수정");
		vo.setBoardNo(5);
		
		Assertions.assertEquals(1, boardMapper.updateBoard(vo));
	}
	
	@Test
	@Disabled
	public void selectListTest() {
		List<BoardVO> boardList = boardMapper.selectBoardList();
		
		boardList.stream().forEach(vo -> System.out.println(vo.toString()));
		
		Assertions.assertEquals(14, boardList.size());
	}
	
	
	@Test
	@Disabled	
	@DisplayName("insertTest") // Junit 테스트 이름 지정
	public void insertTest() { // insert 테스트
		BoardVO vo;
		for(int i = 700; i <=799; i++) {
			vo = new BoardVO(); // test용 BoardVO
			vo.setBoardTitle("title" + i);
			vo.setBoardWriter("writer" + i);
			vo.setBoardContent("content" + i);
			Assertions.assertEquals(1, boardMapper.insertBoard(vo)); // 기대값은 1, 실행할 구문은 boardMapper.insertBoard(vo)
		}
	}
	
	@Test
	@Disabled
	public void connTest() throws SQLException { // Connection 테스트
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Connection conn = sqlSession.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("select * from tb_board");
//		
//		while(rs.next()) {
//			log.info("check : " + rs.getString(2));
//		}
		
//		Assertions.assertNotNull(conn); // conn객체가 null이 아니여야 한다.
//		Assertions.assertNull(conn); // conn객체가 null이여야 한다.
		// 테스트 결과로 확인
	}
}
