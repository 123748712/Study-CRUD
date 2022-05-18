package kr.or.board.service;

import java.util.List;

import kr.or.board.domain.BoardVO;
import kr.or.board.domain.PageCondDTO;

// Service vs Mapper(DAO)
// Service는 Mapper가 실행한 구문의 return값을 if문을 이용해 체크한다. (Business Logic)
public interface BoardService {

	public int insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(int boardNo);
	public BoardVO selectBoard(int boardNo);
	public List<BoardVO> selectBoardList();
	public List<BoardVO> selectBoardPage(PageCondDTO pageCondDTO);
	public int selectBoardTotalCnt();
}
