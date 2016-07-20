package haust.vk.c_cglib;

public class App {
	public static void main(String[] args) {
		//Ŀ�����
		UserDao target = new UserDao();
		//class class haust.vk.c_cglib.UserDao
		System.out.println(target.getClass());
		
		//�������
		UserDao proxy=(UserDao) new ProxyFactory(target).getProxyInstance();
		//UserDao �����ࣺclass haust.vk.c_cglib.UserDao$$EnhancerByCGLIB$$6e26a71
		System.out.println(proxy.getClass());
		
		//ִ�д������ķ���
		proxy.save();
	}
	
}
