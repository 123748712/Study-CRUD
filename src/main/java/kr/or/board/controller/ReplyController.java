package kr.or.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.board.domain.ReplyVO;
import kr.or.board.service.ReplyService;
import lombok.extern.slf4j.Slf4j;

//@RestController // @Controller, @ResponseBody를 합친 어노테이션
@Controller
@RequestMapping("/reply")
@Slf4j
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping(value = "/list", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<ReplyVO> getReplyList(@RequestParam("boardNo") int boardNo) {
		
		log.info("ck get : " + boardNo);
		
		return replyService.selectReplyList2(boardNo);
	}

	@PostMapping(value = "/list", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<ReplyVO> postReplyList(@RequestParam("boardNo") int boardNo) {
		
		log.info("ck post : " + boardNo);
		
		return replyService.selectReplyList2(boardNo);
	}
	
	@PostMapping(value = "/write", produces = "application/json;charset=utf-8")
	@ResponseBody
	public int postReplyWrite(@RequestBody ReplyVO replyVO) {
		log.info("no > " + replyVO.getBoardNo() + " title > " + replyVO.getReplyTitle() + " content > " + replyVO.getReplyContent() + " writer > " + replyVO.getReplyWriter());
		return replyService.insertReply(replyVO);
	}
	
	@PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public int postReplyDelete(@RequestBody int replyNo) {
		log.info("no > " + replyNo);
		return replyService.deleteReply(replyNo);
	}
	
	@PostMapping(value = "/update", produces = "application/json;charset=utf-8")
	@ResponseBody
	public int postReplyUpdate(@RequestBody ReplyVO replyVO) {
		log.info("no > " + replyVO.getReplyNo() + " title > " + replyVO.getReplyTitle() + " content > " + replyVO.getReplyContent() + " writer > " + replyVO.getReplyWriter());
		return replyService.updateReply(replyVO);
	}
}
