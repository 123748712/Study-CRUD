package kr.or.board.domain;

import lombok.Getter;
import lombok.ToString;

// 페이지 범위 산수 모음 클래스
@Getter
@ToString
public class PageDTO {
	private int total;
	private int startPage;
	private int endPage;
	private boolean previous = true;
	private boolean next = true;
	private PageCondDTO pageCondDTO;
	
	public PageDTO(PageCondDTO pageCondDTO, int total) {
		this.pageCondDTO = pageCondDTO;
		// 한 화면에 1..10 으로 페이지가 10개씩 나타나야한다고 가정
		this.endPage = (int)Math.ceil(pageCondDTO.getPageNum() / (pageCondDTO.getPageRange()*1.0)) * pageCondDTO.getPageRange();
		// 게시글이 한개여도 다음 페이지로 이동해야하기 때문에 반올림으로 소수점 자리가 0이 아니면 반올림한다.
		
		this.total = total;
		
		this.startPage = this.endPage - (pageCondDTO.getPageRange()-1);
		if(this.startPage <= 1) {
			this.previous = false; // 첫 페이지라면 이전버튼 비활성화
			this.startPage = 1;
		}
		
		int realEndPage = (int) Math.ceil(this.total / (pageCondDTO.getPageSize()*1.0));
		if(this.endPage >= realEndPage) {
			this.next = false; // 마지막페이지라면 다음버튼 비활성화
			this.endPage = realEndPage;
		}
		
	}
}