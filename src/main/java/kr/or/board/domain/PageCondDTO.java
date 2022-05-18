package kr.or.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
//@Setter
@ToString // List페이지로 처음 올때는 Default 값이 필요
@Slf4j
public class PageCondDTO {
	private int pageNum;
	private int pageSize;
	
	// Default생성자를 이용해서 초기값 할당 
	public PageCondDTO() {
		this(1,10);
	}
	
	public PageCondDTO(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public void setPageNum(int pageNum) {
		log.info("setPageNum 자동 호출");
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		log.info("setPageSize 자동 호출");
		this.pageSize = pageSize;
	}
}