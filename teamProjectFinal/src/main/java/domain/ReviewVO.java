package domain;

import org.apache.ibatis.type.Alias;

@Alias("reviewVO")
public class ReviewVO {
	private int num;
	private String item;
	private String img;
	private String id;
	private String content;
	private String type;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "\nnum:"+getNum()+
				"\nid:"+getId()+
				"\nimg:"+getImg()+
				"\nitem:"+getItem()+
				"\ncontent:"+getContent()+
				"\ntype:"+getType();
	}
}