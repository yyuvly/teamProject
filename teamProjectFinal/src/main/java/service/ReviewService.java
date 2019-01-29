package service;

import java.util.List;

import domain.PageCriteria;
import domain.ReviewVO;

public interface ReviewService {
	public abstract int count();
	public abstract int hotelcount();
	public abstract int goodscount();
	public abstract List<ReviewVO> list(PageCriteria pc);
	public abstract List<ReviewVO> hotellist(PageCriteria pc);
	public abstract List<ReviewVO> goodslist(PageCriteria pc);
	public abstract void regist(ReviewVO reviewVO);
}
