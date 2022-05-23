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
	
	@NotEmpty
	private String boardTitle;
	
	@NotEmpty
	private String boardWriter;
	
	@NotEmpty
	private String boardContent;
	
	private Date boardRegdate;
	private Date boardUpdate;
}