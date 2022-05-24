package kr.or.board.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	private int boardNo;
	
	@NotEmpty(message = "제목 미작성")
	private String boardTitle;
	
	@NotEmpty(message = "작성자 미작성")
	private String boardWriter;
	
	@NotEmpty(message = "내용 미작성")
	private String boardContent;
	
	private Date boardRegdate;
	private Date boardUpdate;
}