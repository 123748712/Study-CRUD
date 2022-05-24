package kr.or.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.board.domain.BoardVO;
import kr.or.board.domain.PageCondDTO;
import kr.or.board.domain.PageDTO;
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
	public String postWrite(@ModelAttribute("vo") @Valid BoardVO boardVO, Errors errors, Model model) {
		log.info("ck : " + boardVO.toString());   // 검증하고 싶은 데이터가 있다면 변수타입 앞에 @Valid 어노테이션 기입
												  // 검증 결과를 Errors 객체에 담아준다.
		if(errors.hasErrors()) { // validation 에러가 있다면 (즉, Errors 객체에 에러가 담겼다면)
			return "write2"; 	 // 다시 write 로 돌아감
		}
		
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
	public String getList(Model model, PageCondDTO pageCondDTO) {
		log.info("ck : " + "redirect list 이동");
//		List<BoardVO> boardList = boardService.selectBoardList();
		PageDTO pageDTO = new PageDTO(pageCondDTO, boardService.selectBoardTotalCnt());
		
		List<BoardVO> boardList = boardService.selectBoardPage(pageCondDTO);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		return "list";
	}
	
	@GetMapping("/read")
	public String getRead(Model model, @RequestParam("boardNo") int boardNo) { 
									// boardNo가 int타입이기 때문에 int타입으로 매핑이 된다. 사용하지 않는다면 String 타입으로 받아온다.
		log.info("상세페이지 접근 확인");
		model.addAttribute("boardVO", boardService.selectBoard(boardNo));
		
		return "read";
	}
	
	@PostMapping("/modify")
	public String postModify(BoardVO vo, Model model, RedirectAttributes rattr) {
		// 일회성 메세지를 담는 객체
		rattr.addFlashAttribute("onetimemsg", "수정 성공");
		boardService.updateBoard(vo);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete")
	public String postDelete(BoardVO vo, Model model, RedirectAttributes rattr) {
		boardService.deleteBoard(vo.getBoardNo());
		rattr.addFlashAttribute("onetimemsg", "삭제 성공");
		return "redirect:/board/list";
	}
}