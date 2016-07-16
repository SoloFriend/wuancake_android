package haust.vk.b_second_cache;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	
	//1.���Զ�������ʹ��
	// û��/����  ��������
	@Test
	public void testCriteria() throws Exception {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		//��ѯһ��
		Dept dept1 =(Dept) session1.get(Dept.class, 1);
		dept1.getEmps().size();// ����
		
		session1.beginTransaction().commit();
		session1.close();
		
		System.out.println("----------");
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		//��ѯһ��
		dept1 =(Dept) session2.get(Dept.class, 1);
		// �����������úã� ���ﲻ��ѯ���ݿ�
		dept1.getEmps().size();
		
		session2.beginTransaction().commit();
		session2.close();
	}
	
	
	@Test
	public void testListCache() throws Exception {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		//��ѯһ��
		Query q = session1.createQuery("from Dept").setCacheable(true);// ��setCacheable  ָ���Ӷ��������ң������Ƿ���������桿
		System.out.println(q.list());
		
		session1.beginTransaction().commit();
		session1.close();
		
		System.out.println("----------");
		
		Session session2 = sf.openSession();
		session1.beginTransaction();
		
		//��ѯһ��
		q = session1.createQuery("from Dept").setCacheable(true);
		System.out.println(q.list());// ����ѯ���ݿ⣺ ��Ҫ������ѯ����
		
		session2.beginTransaction().commit();
		session2.close();
	}
}
