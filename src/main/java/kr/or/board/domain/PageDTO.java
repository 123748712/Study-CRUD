package kr.or.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 페이지 범위 산수 모음 클래스
@Getter
@ToString
public class PageDTO {
	private int total;
	private int startPage;
	private int endPage;
	private PageCondDTO pageCondDTO;
	
	public PageDTO(PageCondDTO pageCondDTO, int total) {
		this.pageCondDTO = pageCondDTO;
		// 한 화면에 1..10 으로 페이지가 10개씩 나타나야한다고 가정
		this.endPage = (int)Math.ceil(pageCondDTO.getPageNum() / 10.0)*10;
		// 게시글이 한개여도 다음 페이지로 이동해야하기 때문에 반올림으로 소수점 자리가 0이 아니면 반올림한다.
		
		int realEndPage = (int) Math.ceil((total/10.0));
		if(this.endPage > realEndPage) {
			this.endPage = realEndPage;
		}
		
		this.startPage = this.endPage - 9;
		if(this.startPage < 1) {
			this.startPage = 1;
		}
		
		this.total = total;
	}
}