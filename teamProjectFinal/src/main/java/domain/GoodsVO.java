package domain;

import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("goodsVO")
public class GoodsVO {
	
	private int num;
	private String item;
	private String img;
	private int price;
	private int count;
	private String descript;
	private String[] desarr;
	
	private List<MultipartFile> descriptFile;
	
	public GoodsVO() {}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<MultipartFile> getDescriptFile() {
		return descriptFile;
	}

	public void setDescriptFile(List<MultipartFile> descriptFile) {
		this.descriptFile = descriptFile;
	}

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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String[] getDesarr() {
		return desarr;
	}
	public void setDesarr(String[] desarr) {
		this.desarr = desarr;
	}
}
