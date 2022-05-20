package kr.or.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		log.info("ck : " + boardNo);
		
		return replyService.selectReplyList2(boardNo);
	}
}
