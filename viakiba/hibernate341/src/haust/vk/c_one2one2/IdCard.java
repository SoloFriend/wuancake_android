package haust.vk.c_one2one2;

public class IdCard {
	private int user_id;
	//���֤�ŵ�����
	private String cardNum;
	//���֤��ַ
	private String place;
	//���֤���û� һ��һ
	private User user;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
