package haust.vk.c_property;

public class User {
	private int id;
	private String name;
	//////////////  -->ͨ������ע������ֵ
	public void setId(int id) {
		this.id = id;
	}
	
	//////////////  -->ͨ������ע������ֵ
	public void setName(String name) {
		this.name = name;
	}
	
	//============================
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	//============================
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public User() {
		super();
		System.out.println("user���� �����޲ι�����");
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("user���� ���ô�����������");
	}
	
	public void init_user() {
		// TODO Auto-generated method stub
		System.out.println("��������֮�󣬳�ʼ��");
	}
	
	public void destory_user() {
		// TODO Auto-generated method stub
		System.out.println("IOC�������� user�������");
	}
	
	
	
	
}
