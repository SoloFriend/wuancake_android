package haust.vk.b_one2Many;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class testApp2 {
	//��ȡ
	@Test
	public void testGet() throws Exception {
		SessionFactory sf = new Configuration().configure().addClass(Dept.class).addClass(Employee.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// ͨ��Ա��������ȡ����һ��
		
		/*
		Employee emp =(Employee)  session.get(Employee.class, 1);
		System.out.println(emp.getEmpName());
		System.out.println(emp.getDept().getDeptName());
		*/
		// ͨ�����ŷ�����ȡ����һ��
		Dept dept =(Dept)  session.get(Dept.class, 1);
		
		System.out.println(dept.getDeptName());
		//System.out.println(dept.getEmps());
		
		tx.commit();
		session.close();
	}
}
