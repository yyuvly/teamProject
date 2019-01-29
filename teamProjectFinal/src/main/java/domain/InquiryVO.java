package domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("inquiryVO") // 어노테이션 : 라벨
public class InquiryVO { // DB와 데이터를 주고 받을 때 사용할 VO
	
	private int num;			// 번호(시퀀스)
	private String item;		// 제목
	private String name;		// 아이디
	private String content;		// 내용
	private String type;		// 호텔or물품
	private String password;	// 비밀번호
	private int cnt;			// 조회수
	private Timestamp regDate;	// 날짜
	
	private int rnum;		// 글 그룹 번호
	private int rstep;		// 답글 순서
	private int rlevel;		// 답글의 답글(깊이) depth 들여쓰기
	
	
/*	private int seq;
	
	@Length(min=2, max=5, message="제목은 2자 이상, 5자 미만 입력해야 합니다.")
	private String title;
	
	@NotEmpty(message="내용을 입력하세요")
	private String content;
	
	@NotEmpty(message="작성자를 입력하세요")
	private String writer;
	
	private int password;
	private Timestamp regDate;
	private int cnt;*/

	public InquiryVO() {}
	/*
	public InquiryVO(String item, String name, String content, String type) {
		super();
		this.item = item;
		this.name = name;
		this.content = content;
		this.type = type;
		this.cnt = 0;
	}
*/
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getRstep() {
		return rstep;
	}
	public void setRstep(int rstep) {
		this.rstep = rstep;
	}
	public int getRlevel() {
		return rlevel;
	}
	public void setRlevel(int rlevel) {
		this.rlevel = rlevel;
	}
}
