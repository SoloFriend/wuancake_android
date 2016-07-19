package hausrt.vk.a_hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2_bean {
	/**
	 * 1) ���󴴽��� ����/����
	 * 	scope="singleton", Ĭ��ֵ�� �� Ĭ���ǵ���	��service/dao/�����ࡿ
	 *  scope="prototype", ������ 				��Action����
	 * 
	 * 
	 * 2) ʲôʱ�򴴽�?
	 * 	  scope="prototype"  ���õ������ʱ�򣬲Ŵ�������
	 *    scope="singleton"  ������(������ʼ��֮ǰ)�� ���Ѿ�������bean��������Ӧ��ֻ��һ����
	 * 3)�Ƿ��ӳٴ���
	 * 	  lazy-init="false"  Ĭ��Ϊfalse,  ���ӳٴ�������������ʱ��ʹ�������
	 * 	  lazy-init="true"   �ӳٳ�ʼ���� ���õ������ʱ��Ŵ�������
	 *    ��ֻ�Ե�����Ч��
	 * 4) ��������֮�󣬳�ʼ��/����
	 * 	  init-method="init_user"       ����Ӧ�����init_user�������ڶ��󴴽���֮��ִ�� ��
	 *    destroy-method="destroy_user"  ���ڵ������������destriy����ʱ��ִ�У�(������ʵ����)��
	 */
	@Test
	public void testIOC() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/hausrt/vk/a_hello/applicationContext.xml");
		System.out.println("----��������-----");
		
		// �������л�ȡbean
		User user =(User) ac.getBean("user");
		User user1 =(User) ac.getBean("user");
		
		System.out.println(user);
		System.out.println(user1);
		
		// ������������ 
		ac.destroy();
	}
	
	@Test
	public void testApp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/hausrt/vk/a_hello/applicationContext.xml");
		
		System.out.println("=====�����������====");
		
		User user1=(User) ac.getBean("user1");
		
	}
}
