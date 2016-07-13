package haust.vk.e_extends1;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class App {
	private static SessionFactory sf;
	static{
		sf=new Configuration()
				.configure()
				.addClass(Cat.class)
				.buildSessionFactory();
	}
	
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ����
		/*Cat cat = new Cat();
		cat.setName("��è");
		cat.setEatMouse("ץС����");
		session.save(cat);*/
		
		// ��ȡʱ��ע�⣺��дhql��ѯ��ʹ�ã�ͨ�������ѯ����д�����ȫ��
		Query q = session.createQuery("from haust.vk.e_extends1.Animal");
		List<Animal> list = q.list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
