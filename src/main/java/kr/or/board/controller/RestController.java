package kr.or.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class RestController {
	
	@PutMapping("/put")
	@ResponseBody
	public String putTest() {
		return "put comming";
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public String deleteTest() {
		return "delete comming";
	}
}
