package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.ReviewDao;
import domain.PageCriteria;
import domain.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService{
	private ReviewDao reviewDao;
	public ReviewDao getReviewDao() {
		return reviewDao;
	}
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	@Override
	public int count() {
		return reviewDao.count();
	}
	@Override
	public List<ReviewVO> list(PageCriteria pc) {
		return reviewDao.list(pc);
	}
	@Override
	public int hotelcount() {
		return reviewDao.hotelcount();
	}
	@Override
	public List<ReviewVO> hotellist(PageCriteria pc) {
		return reviewDao.hotellist(pc);
	}
	@Override
	public int goodscount() {
		return reviewDao.goodscount();
	}
	@Override
	public List<ReviewVO> goodslist(PageCriteria pc) {
		return reviewDao.goodslist(pc);
	}
	@Override
	public void regist(ReviewVO reviewVO) {
		reviewDao.regist(reviewVO);
	}
}
