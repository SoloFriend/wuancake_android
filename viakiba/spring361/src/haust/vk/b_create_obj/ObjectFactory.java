package haust.vk.b_create_obj;

public class ObjectFactory {
	public User getInstance(){
		return new User(100,"������Ŷ�Ǹ�ʵ������");
	}
	
	public static User getStaticInstance(){
		return new User(101,"���������þ�̬����");
	}
}
