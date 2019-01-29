package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.InquiryDao;
import domain.InquiryVO;

@Service // 이건 또 뭐임
public class InquiryServiceImpl implements InquiryService { // 인터페이스 inquiryService를 구현한 서비스 클래스
	
	private InquiryDao inquiryDao;
	
	public InquiryDao getInquiryDao() {
		return inquiryDao;
	}
	
	public void setInquiryDao(InquiryDao inquiryDao) {
		this.inquiryDao = inquiryDao;
	}
	
	@Override
	public List<InquiryVO> list() {
		return inquiryDao.list();
	}
	@Override
	public InquiryVO selectByNum(int num) {
		return inquiryDao.select(num);
	}
	@Override
	public InquiryVO read(int num) {			// 읽기
		inquiryDao.updateReadCount(num);
		return inquiryDao.select(num);
	}
	@Override
	public void write(InquiryVO inquiryVO) {	// 작성
		inquiryDao.insert(inquiryVO);
	}
	@Override
	public int edit(InquiryVO inquiryVO) {		// 수정
		return inquiryDao.update(inquiryVO);
	}
	@Override
	public int delete(InquiryVO inquiryVO) {	// 삭제
		return inquiryDao.delete(inquiryVO);
	}
	
	@Override
	public void replyWrite(InquiryVO inquiryVO) {
		inquiryDao.replyInsert(inquiryVO);
	}
	@Override
	public void replyEdit(InquiryVO inquiryVO) {
		inquiryDao.replyUpdate(inquiryVO);
	}
}