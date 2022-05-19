package kr.or.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.board.domain.ReplyVO;

@Mapper
public interface ReplyMapper {

	public int insertReply(ReplyVO replyVO);
	public int updateReply(ReplyVO replyVO);
	public int deleteReply(int replyVO);
	public ReplyVO selectReply(int replyVO);
	public List<ReplyVO> selectReplyList();
	public List<ReplyVO> selectReplyList2(int boardNo); // 게시글에 해당하는 댓글
}
