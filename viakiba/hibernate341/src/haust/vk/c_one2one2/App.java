package haust.vk.c_one2one2;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(User.class)
				 .addClass(IdCard.class)
				 .buildSessionFactory();
	}
	
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//�����û�
		User user = new User();
		user.setUserName("jack1");
		
		//�������֤����
		IdCard idCard = new IdCard();
		idCard.setCardNum("564674646445");
		idCard.setPlace("hsah");
		idCard.setUser(user);
		
		//��ϵ����   �������� idCard ��
		idCard.setUser(user);
		
		session.save(idCard);
		
		
		session.beginTransaction().commit();
		session.close();
	}
}
