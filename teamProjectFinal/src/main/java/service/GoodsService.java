package service;

import java.util.List;

import domain.GoodsVO;

public interface GoodsService {
	
	public abstract List<GoodsVO> list();

	public abstract GoodsVO detail(int num);
	
	public abstract GoodsVO divide(int num);
	
	public abstract void regist(GoodsVO goodsVO);
	
	public abstract int delete(GoodsVO goodsVO);
	
	public abstract int edit(GoodsVO goodsVO);
	
	
}
