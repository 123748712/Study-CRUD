package kr.or.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.board.domain.BoardVO;

@Mapper
public interface BoardMapper {

	public int insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(int boardNo);
	public int selectBoard(int boardNo);
	public List<BoardVO> selectBoardList();
}