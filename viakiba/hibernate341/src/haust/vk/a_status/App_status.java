package haust.vk.a_status;


import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_status {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(User.class)
				 .buildSessionFactory();
	}
	
	//
	@Test
	public void testSaveset() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//��������   ��ʱ״̬
		User user = new User();
		user.setUserName("UserName1");
		
		//����   �־û�״̬
		session.save(user);
		user.setUserName("ceshi");//��ӳ�����ݿ���
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGetset() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//��ȡ����
		User user =(User) session.get(User.class, 1);
		System.out.println(user.getUserId()+"--"+user.getUserName());
		
		//
		user.setUserName("sda");//hibernate���Զ������ݿ�ƥ�䣨һ�����棩�����һ���͸������ݿ�
		
		
		session.beginTransaction().commit();
		session.close();
		
		//�ر�֮��
		user.setUserName("Jack444444444");
		// ��ӡ							������״̬��
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
	}
}
