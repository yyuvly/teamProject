package dao;

import java.util.List;

import domain.InquiryVO;

public interface InquiryDao { // 확장성을 고려하여 인터페이스로 만듬
	
	public abstract List<InquiryVO> list();				// 
	
	public abstract InquiryVO select(int num);			// 찾기
	
	public abstract void insert(InquiryVO inquiryVO);	// 입력
	
	public abstract int update(InquiryVO inquiryVO);	// 수정
	
	public abstract int updateReadCount(int num);		// 조회수
	
	public abstract int delete(InquiryVO inquiryVO);	// 삭제
	
	public abstract int deleteAll();					// 모두 삭제

	public abstract void replyInsert(InquiryVO inquiryVO);

	public abstract void replyUpdate(InquiryVO inquiryVO);
	

}
