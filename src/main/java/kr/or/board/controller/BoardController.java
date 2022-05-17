package kr.or.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String postWrite(@ModelAttribute("vo") BoardVO boardVO, Model model) {
		log.info("ck : " + boardVO.toString());
		int result = boardService.insertBoard(boardVO);
		if(result != 1) {
			model.addAttribute("error", "write fail");
		}
		// forward방식이 아닌 redirect방식
		// get방식의 /board/list 맵핑이 처리
		// forward : url은 write지만 view는 list
		// redirect : url,view도 같이 list로 전환
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String getList(Model model) {
		log.info("ck : " + "redirect list 이동");
		List<BoardVO> boardList = boardService.selectBoardList();
		
		model.addAttribute("boardList", boardList);
		return "list";
	}
//	
//	@GetMapping("/index")
//	public String goIndex() {
//		// forwarding => /WEB-INF/views/index.jsp를 응답
//		return "board/index";
//	}
//	
//	// 메뉴의 buttons 클릭시 이동할 페이지 매핑
//	@GetMapping("/buttons")
//	public String buttons() {
//		return "board/buttons";
//	}
//	
//	@GetMapping("/cards")
//	public String cards() {
//		return "board/cards";
//	}
}