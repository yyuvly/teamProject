package service;

import java.util.List;

import domain.InquiryVO;

public interface InquiryService { // 확장성을 생각하여 dao와 마찬가지로 인터페이스로 구현
	/* 서비스 구현
	 * 일반적으로 dao는 DB테이블당 하나씩 만듬
	 * 그리고 서비스를 구현하면 dao와 연동하는 서버 기술이나 벤더별 DBMS에 종속되지 않는 로직을 구현할 수 있다.
	 */
	
	public abstract List<InquiryVO> list();
	
	public abstract InquiryVO selectByNum(int num);
	
	public abstract InquiryVO read(int num);
	
	public abstract void write(InquiryVO inquiryVO);
	
	public abstract int edit(InquiryVO inquiryVO);

	public abstract int delete(InquiryVO inquiryVO);
	

	public abstract void replyWrite(InquiryVO inquiryVO);

	public abstract void replyEdit(InquiryVO inquiryVO);


}
