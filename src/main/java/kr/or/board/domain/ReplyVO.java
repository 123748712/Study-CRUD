package kr.or.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//	create table tb_reply (
//		    reply_no number(10) primary key,
//		    board_no number(10) not null,
//		    reply_title varchar2(50) not null,
//		    reply_writer varchar2(50) not null,
//		    reply_content varchar2(500) not null,
//		    reply_regdate date default sysdate,
//		    constraint fk_board foreign key(board_no) references tb_board (board_no)
//		);

@Setter
@Getter
@ToString
public class ReplyVO {
	private int replyNo;
	private int boardNo;
	private String replyTitle;
	private String replyWriter;
	private String replyContent;
	private Date replyRegdate;
}