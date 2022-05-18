package kr.or.board.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.board.domain.BoardVO;
import kr.or.board.domain.PageCondDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:config/spring/root-context.xml")
public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Test
	@Disabled
	public void selectList() {
		List<BoardVO> boardList = boardService.selectBoardList();
		
		// :: -> 메소드참조(람다)
		boardList.forEach(System.out::println);
		Assertions.assertEquals(14, boardList.size());
	}
	
	@Test
	public void selectPage() {
//		PageCondDTO pageCondDTO = new PageCondDTO(); // Default 생성자를 통해 (1,5)값을 할당해줌
		PageCondDTO pageCondDTO = new PageCondDTO(2,7,5); // 따로 값을 넣어줘도 가능
//		pageCondDTO.setPageNum(2);
//		pageCondDTO.setPageSize(5);
		// 5개의 boardVO를 한페이지로 지정해서 1page 가져오기.
		
		List<BoardVO> boardList = boardService.selectBoardPage(pageCondDTO);
		
		boardList.forEach(System.out::println);
		Assertions.assertEquals(5, boardList.size());
	}
}