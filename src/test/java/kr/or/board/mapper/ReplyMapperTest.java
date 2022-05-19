package kr.or.board.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.board.domain.ReplyVO;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:config/spring/root-context.xml")
@Slf4j
public class ReplyMapperTest {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	@Disabled
	public void insertTest() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBoardNo(2);
		replyVO.setReplyTitle("title");
		replyVO.setReplyWriter("writer");
		replyVO.setReplyContent("content");
		
		Assertions.assertEquals(1, replyMapper.insertReply(replyVO));
	}

	@Test
	@Disabled
	public void updateTest() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setReplyNo(2);
		replyVO.setReplyTitle("title1");
		replyVO.setReplyWriter("writer1");
		replyVO.setReplyContent("content1");
		
		Assertions.assertEquals(1, replyMapper.updateReply(replyVO));
	}
	
	@Test
	@Disabled
	public void deleteTest() {
		Assertions.assertEquals(1, replyMapper.deleteReply(2));
	}
	
	@Test
	@Disabled
	public void selectTest() {
		ReplyVO replyVO = replyMapper.selectReply(3);
		
		Assertions.assertEquals(1, replyVO.getBoardNo());
		// select한 boardNo가 1이라면
	}

	@Test
	@Disabled
	public void selectListTest() {
		List<ReplyVO> replyList = replyMapper.selectReplyList();
		
		replyList.stream().forEach(vo -> {
			log.info("" + vo.getBoardNo());
			log.info("" + vo.getReplyTitle());
			log.info("" + vo.getReplyWriter());
			log.info("" + vo.getReplyContent());
		});
		Assertions.assertEquals(4, replyList.size());
	}
	
	@Test
	public void selectReplyListTest() {
		List<ReplyVO> replyList = replyMapper.selectReplyList2(1);
		
		replyList.stream().forEach(vo -> {
			log.info("" + vo.getBoardNo());
			log.info("" + vo.getReplyTitle());
			log.info("" + vo.getReplyWriter());
			log.info("" + vo.getReplyContent());
		});
		Assertions.assertEquals(3, replyList.size());
	}
	
}

