package kr.or.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString // List페이지로 처음 올때는 Default 값이 필요
@Slf4j
public class PageCondDTO {
	private int pageNum; // 페이지 번호
	private int pageSize; // 한페이지당 출력되는 글 갯수
	private int pageRange; // 한번에 출력되는 페이지 갯수
	
	// Default생성자를 이용해서 초기값 할당 
	public PageCondDTO() {
		this(1,10,10);
	}
	
	public PageCondDTO(int pageNum, int pageSize, int pageRange) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageRange = pageRange;
	}
}