package haust.vk.a_static;

public class App {
	public static void main(String[] args) {
		//Ŀ�����
		IUserDao target = new UserDao();
		
		//����
		IUserDao proxy1=new UserDaoProxy(target);
		proxy1.save();
	}
}
