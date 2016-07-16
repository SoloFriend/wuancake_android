package haust.vk.a_query;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_page {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	
	//��ҳ��ѯ
	@Test
	public void testCriteria() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Employee");
		ScrollableResults scroll = q.scroll();   // �õ������Ľ����
		scroll.last();							 //  ���������һ��
		int totalCount = scroll.getRowNumber()+1;// �õ������ļ�¼�������ܼ�¼��
		
		//���÷�ҳ����
		q.setFirstResult(0);
		q.setMaxResults(3);
		
		//��ѯ
		System.out.println(q.list());
		System.out.println("�ܼ�¼��"+totalCount);
		
		session.beginTransaction().commit();
		session.close();
	}
}
