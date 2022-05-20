package kr.or.board.service;

import java.util.List;

import kr.or.board.domain.ReplyVO;

public interface ReplyService {
	public int insertReply(ReplyVO replyVO);
	public int updateReply(ReplyVO replyVO);
	public int deleteReply(int replyVO);
	public ReplyVO selectReply(int replyVO);
	public List<ReplyVO> selectReplyList();
	public List<ReplyVO> selectReplyList2(int boardNo);
}
