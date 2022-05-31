package kr.or.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

// 구글 웹스토어 -> rest client 검색 후 설치
// 부가설치, 회원가입 없이 HTTP Request 사용 가능
// URL method가 결정하는 작업을 restful 이라고 함
@Controller
@RequestMapping("/restful")
@Slf4j
public class RestfulController {

	// DB 대용 Static List
	private static java.util.List<String> members = new ArrayList<String>();

	public RestfulController() {
		// 임시 데이터
		RestfulController.members.add("member0");
		RestfulController.members.add("member1");
		RestfulController.members.add("member2");
		RestfulController.members.add("member3");
		RestfulController.members.add("member4");
		RestfulController.members.add("member5");
		RestfulController.members.add("member6");
		RestfulController.members.add("member7");
	}                                        

	// GET은 조회(select)로 사용
	@GetMapping(value = "/member/{id}", produces = "application/json;charset:utf-8") // {id}의 값을 int index에 담아준다.
	@ResponseBody
	public String getReq(@PathVariable("id") int index) {
		log.info("id: " + index);
		return RestfulController.members.get(index);
	}

	// POST는 생성(insert)으로 사용
	@PostMapping(value = "/member", produces = "application/json;charset:utf-8")
	@ResponseBody
	public List<String> postReq(@RequestBody String name) {
		log.info("name: " + name);
		RestfulController.members.add(name);
		return RestfulController.members;
	}

	// PUT은 수정(update)으로 사용
	@PutMapping(value = "/member", produces = "application/json;charset:utf-8")
	@ResponseBody
	public List<String> putReq(@RequestBody Map<Integer, String> map) {
		log.info("map {}" + map.keySet());

		Set<Integer> keySet = map.keySet();
		int index = keySet.iterator().next();

		RestfulController.members.set(index, map.get(index));
		return RestfulController.members;
	}

	// Delete는 삭제(delete)로 사용
	@DeleteMapping(value = "/member/{id}", produces = "application/json;charset:utf-8")
	@ResponseBody
	public List<String> deleteReq(@PathVariable("id") int index) {
		log.info("ck: " + index);
		RestfulController.members.remove(index);
		return RestfulController.members;
	}

	// 단순 문자열 전송
	@PostMapping(value = "/member2", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String postText(@RequestBody String text) throws Exception {
		log.info(text);
		return text;
	}
}
