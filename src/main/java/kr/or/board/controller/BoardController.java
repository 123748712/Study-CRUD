package kr.or.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.board.domain.BoardVO;
import kr.or.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/write")
	public String getWrite() {
		return "write";
	}
	
	@PostMapping("/write")
	public String postWrite(BoardVO boardVO, Model model) {
		log.info("ck : " + boardVO.toString());
		boardService.insertBoard(boardVO);
		return "list";
	}
	
	@GetMapping("/list")
	public String getList() {
		return "list";
	}
}
