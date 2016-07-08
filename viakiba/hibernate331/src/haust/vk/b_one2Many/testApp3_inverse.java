package haust.vk.b_one2Many;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class testApp3_inverse {
	private static SessionFactory sf;
	
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	
	//��������
	 // inverse=true,  �������ù�����
	//                 ��ʱ�Ĺ���Ӧ��ͨ��Ա����ά����

	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//���Ŷ���
		Dept dept = new Dept();
		dept.setDeptName("dept_inverse");
		
		//Ա������
		Employee employee = new Employee();
		employee.setEmpName("emp_inverse");
		
		//������ϵ  һ�Զ�
		employee.setDept(dept);
		
		//����
		session.save(employee);
		session.save(dept);
		
		session.beginTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, 5);
		System.out.println(dept.getEmps());
		
		session.beginTransaction().commit();
		session.close();
	}
	
	/*3. �Ƿ�����inverse���Խ��������ϵӰ�죿
	  inverse=false��  ���Խ������
	  inverse=true��  ��ǰ��(����)û�п���Ȩ�����ܽ��������ϵ(��������update���,Ҳ���ᱨ��)
	 */
	@Test
	public void testRemRea() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//��ȡ����
		Dept dept = (Dept) session.get(Dept.class, 5);
		dept.getEmps().clear();
		
		session.getTransaction().commit();
		session.close();
	}
	
	/*
	 3. �Ƿ�����inverse���ԣ���ɾ�������жԹ�����ϵ��Ӱ��?
	     inverse=false, �п���Ȩ�� ����ɾ���������������ã���ɾ�����ݡ�
		 inverse=true,  û�п���Ȩ: ���ɾ���ļ�¼�б�������ã��ᱨ��Υ�����������Լ����
						 ���ɾ���ļ�¼û�б����ã�����ֱ��ɾ����
	*/
	
	@Test
	public void testDel() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ��ѯ����
		Dept dept = (Dept) session.get(Dept.class, 6);
		session.delete(dept);
		session.beginTransaction().commit();
		session.close();
	}
}
