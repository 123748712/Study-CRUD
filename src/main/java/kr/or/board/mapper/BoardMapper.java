package kr.or.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.board.domain.BoardVO;
import kr.or.board.domain.PageCondDTO;

@Mapper
public interface BoardMapper {

	public int insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(int boardNo);
	public BoardVO selectBoard(int boardNo);
	public List<BoardVO> selectBoardList();
	
	// 지정된 pageSize만큼 BoardVO List에 담아 page 가져오기
	public List<BoardVO> selectBoardPage(PageCondDTO pageCondDTO);
	
	public int selectBoardTotalCnt(); // 총 게시글 갯수
}