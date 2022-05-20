package kr.or.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.domain.ReplyVO;
import kr.or.board.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int insertReply(ReplyVO replyVO) {
		return replyMapper.insertReply(replyVO);
	}

	@Override
	public int updateReply(ReplyVO replyVO) {
		return replyMapper.updateReply(replyVO);
	}

	@Override
	public int deleteReply(int replyVO) {
		return replyMapper.deleteReply(replyVO);
	}

	@Override
	public ReplyVO selectReply(int replyVO) {
		return replyMapper.selectReply(replyVO);
	}

	@Override
	public List<ReplyVO> selectReplyList() {
		return replyMapper.selectReplyList();
	}

	@Override
	public List<ReplyVO> selectReplyList2(int boardNo) {
		return replyMapper.selectReplyList2(boardNo);
	}

}
