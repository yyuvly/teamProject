package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.GoodsDao;
import domain.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{
	// DB 연결하는 애를 불러옴
	private GoodsDao goodsDao;
	
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}
	
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao=goodsDao;
	}
	// 모든 상품 불러오기 서비스
	@Override
	public List<GoodsVO> list() {
		return goodsDao.list();
	}
	// 상품 상세보기 서비스
	@Override
	public GoodsVO detail(int num) {
		return goodsDao.detail(num);
	}
	// 상품 설명 나누는 서비스
	@Override
	public GoodsVO divide(int num) {
		return goodsDao.divide(num);
	}
	// 상품 등록 서비스
	@Override
	public void regist(GoodsVO goodsVO) {
		goodsDao.insert(goodsVO);
	}
	// 상품 삭제 서비스
	@Override
	public int delete(GoodsVO goodsVO) {
		return goodsDao.delete(goodsVO);
	}
	// 상품 편집 서비스
	@Override
	public int edit(GoodsVO goodsVO) {
		return goodsDao.update(goodsVO);
	}
}
