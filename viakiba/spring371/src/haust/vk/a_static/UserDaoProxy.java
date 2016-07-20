package haust.vk.a_static;

/**
 * �������(��̬����)
 * 	   �������Ҫʵ����Ŀ�����һ���Ľӿ�
 */
public class UserDaoProxy implements IUserDao{
	private IUserDao target;
	
	public UserDaoProxy(IUserDao target) {
		super();
		this.target = target;
	}



	@Override
	public void save() {
		System.out.println("��ʼ���񡣡���");
		
		target.save();//ִ��Ŀ����󷽷�
		
		System.out.println("�ر����񡣡���");
		
	}
	
}
