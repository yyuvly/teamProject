package domain;

import java.sql.Timestamp;

public class OrdersVO {
	private int num;
	private String item;
	private int count;
	private int price;
	private String img;
	private String type; 
	private String ordernum;	
	private String id; //	
	private String info; // 은행, 카드이름
	private String account; // 계좌번호, 카드번호
	private String name; // 입금자명, 서명(소유자명)
	private Timestamp regdate;
	
	
	
	public OrdersVO() {	}



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



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
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



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getOrdernum() {
		return ordernum;
	}



	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Timestamp getRegdate() {
		return regdate;
	}



	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}
