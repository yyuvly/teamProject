package domain;

public class HotelVO {
	
	private String a_name;		//애견 이름
	private int a_age;			//애견 나이
	private String a_gender;	//애견 성별
	private int a_cnt;			//애견 수
	private String checkin;		//체크인시간
	private String checkout;	//체크인시간
	private int price;			//가격
	
	public HotelVO() {}
	
	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public int getA_age() {
		return a_age;
	}

	public void setA_age(int a_age) {
		this.a_age = a_age;
	}

	public String getA_gender() {
		return a_gender;
	}

	public void setA_gender(String a_gender) {
		this.a_gender = a_gender;
	}

	public int getA_cnt() {
		return a_cnt;
	}

	public void setA_cnt(int a_cnt) {
		this.a_cnt = a_cnt;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
