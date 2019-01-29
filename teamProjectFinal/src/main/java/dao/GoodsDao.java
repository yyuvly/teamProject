package dao;


import java.util.List;

import domain.GoodsVO;
// DB에 접근하는 애
public interface GoodsDao {
	
	public abstract List<GoodsVO> list();
	public abstract GoodsVO detail(int num);
	public abstract GoodsVO divide(int num);
	
	public abstract int delete(GoodsVO goodsVO);
	public abstract int update(GoodsVO goodsVO);
	public abstract void insert(GoodsVO goodsVO);
}
