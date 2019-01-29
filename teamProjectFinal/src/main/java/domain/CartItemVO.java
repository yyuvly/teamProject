
package domain;

import org.apache.ibatis.type.Alias;

@Alias("CartItemVO")
public class CartItemVO {
	private int num;
	private String id;
	private String item;
	private int price;
	private String img;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


}
