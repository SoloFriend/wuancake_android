package haust.vk.a_query;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_hql {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	
	/*
	    1)	Get/load������ѯ
		2)	���󵼺���ѯ
		3)	HQL��ѯ��  Hibernate Query language  hibernate �ṩ���������Ĳ�ѯ���ԡ�
		4)	Criteria ��ѯ��   ��ȫ�������Ĳ�ѯ��Query By Criteria  ,QBC��
		5)	SQLQuery�� ����SQL��ѯ
	 */
	
	//1.������ѯ
	@Test
	public void testOne() throws Exception {
		Session session = sf.openSession();
		
		
		session.beginTransaction();
		//1)	Get/load������ѯ
		//1.������ѯ
//		Dept dept = (Dept) session.get(Dept.class, 1);
//		System.out.println(dept);
		//2)	���󵼺���ѯ
		//2.���󵼺���ѯ
//		Dept dept = (Dept) session.get(Dept.class, 1);
//		System.out.println(dept.getDeptName());
//		System.out.println(dept.getEmps().toArray().length);
		
		//3)	HQL��ѯ��  Hibernate Query language  hibernate �ṩ���������Ĳ�ѯ���ԡ�
		//3.HQL��ѯ
		// ע�⣺ʹ��hql��ѯ��ʱ�� auto-import="true" Ҫ����true��
		//  �����false��дhql��ʱ��Ҫָ�����ȫ��
		
		//a.��ѯȫ����
//		Query q = session.createQuery("from Dept");
//		Query q = session.createQuery("select * from Dept");//�����﷨����֧��*
//		Query q = session.createQuery("select d from Dept d");
//		System.out.println(q.list());
		
		//b.��ѯָ���� �����ض������� object��
//		Query q = session.createQuery("select d.deptId,d.deptName from Dept d ");
//		System.out.println(q.list());
		
		//c.��ѯָ���У��Զ���װΪ���󣨱���Ҫ�ṩ�������Ĺ�������
//		Query q = session.createQuery("select new Dept(d.deptId,d.deptName) from Dept d ");
//		System.out.println(q.list());
		
		// d. ������ѯ: һ������/�������and or/between and/ģ����ѯ
		 
		// ������ѯ�� ռλ��
//		Query q = session.createQuery("from Dept d where deptName=?");
//		q.setString(0, "dept1");
//		q.setParameter(0, "dept2");
//		System.out.println(q.list());
		
		// ������ѯ�� ��������
//		Query q = session.createQuery("from Dept d where deptId=:myId or deptName=:name");
//		q.setParameter("myId", 1);
//		q.setParameter("name", "dept1");
//		System.out.println(q.list());
		
		// ��Χ
//		Query q = session.createQuery("from Dept d where deptId between ? and ?");
//		q.setParameter(0, 1);
//		q.setParameter(1, 2);
//		System.out.println(q.list());
		
		// ģ��
//		Query q = session.createQuery("from Dept d where deptName like ?");
//		q.setParameter(0, "%d%");
//		System.out.println(q.list());
		
		// e. �ۺϺ���ͳ��
//		Query q = session.createQuery("select count(*) from Dept d");
//		Object num = q.uniqueResult();
//		System.out.println((Long) num);
		
		// f. �����ѯ
		//-- ͳ��t_employee���У�ÿ�����ŵ�����
		//���ݿ�д����SELECT dept_id,COUNT(*) FROM t_employee GROUP BY dept_id;
		// HQLд��
//		Query q = session.createQuery("select e.dept , count(*) from Employee e group by e.dept");
//		System.out.println(q.list());
		
		session.beginTransaction().commit();
		session.close();
	}
	
	//���Ӳ�ѯ
	//��ӳ���ļ��й�
	
	@Test
	public void testJoin() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//1) ������   ��ӳ���Ѿ����ú��˹�ϵ��������ʱ��ֱ��д��������Լ��ɡ�
//		Query q=session.createQuery("from Dept d inner join d.emps");
//	    System.out.println(q.list());
	    
		//2)��������
//		Query q = session.createQuery("from Dept d left join d.emps");
//		System.out.println(q.list());
		
		//3����������
//		Query q = session.createQuery("select new Employee(e.empName) from Employee e right join e.dept");
//		System.out.println(q.list());
		session.beginTransaction().commit();
		session.close();
	}
	
	// g. ���Ӳ�ѯ - ��������
	@Test
	public void testFetch() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		//1) ����������    ��ʹ��fetch, ����ұ�����ݣ���䵽�������У���
//		Query q = session.createQuery("from Dept d inner join fetch d.emps");
//		System.out.println(q.list());
		
		//2) ������������
    	Query q = session.createQuery("from Dept d inner join fetch d.emps");
    	System.out.println(q.list());
    	
    	/*
    	select
	        dept0_.deptId as deptId0_0_,
	        emps1_.empId as empId1_1_,
	        dept0_.deptName as deptName0_0_,
	        emps1_.empName as empName1_1_,
	        emps1_.salary as salary1_1_,
	        emps1_.dept_id as dept4_1_1_,
	        emps1_.dept_id as dept4_0_0__,
	        emps1_.empId as empId0__ 
    	from
        	t_dept dept0_ 
    	inner join
	        t_employee emps1_ 
	            on dept0_.deptId=emps1_.dept_id
    	 */
    	
		session.beginTransaction().commit();
		session.close();
	}

	//hql ��ѯ�Ż�
	public void bakSession() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//hql д��
//		Query q = session.createQuery("from Dept d where deptId < 10 ");
//		System.out.println(q.list());
		
		//hql �ŵ�ӳ���ļ���
		Query q = session.getNamedQuery("getAllDept");
		System.out.println(q.list());
		/*
		select
	        dept0_.deptId as deptId0_0_,
	        emps1_.empId as empId1_1_,
	        dept0_.deptName as deptName0_0_,
	        emps1_.empName as empName1_1_,
	        emps1_.salary as salary1_1_,
	        emps1_.dept_id as dept4_1_1_,
	        emps1_.dept_id as dept4_0_0__,
	        emps1_.empId as empId0__ 
    	from
        	t_dept dept0_ 
    	inner join
	        t_employee emps1_ 
	            on dept0_.deptId=emps1_.dept_id
		 */
		session.beginTransaction().commit();
		session.close();
	}

	
	
	
	
	
/*	
	
	//��������
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//��������
		Dept dept = new Dept();
		dept.setDeptName("dept1");
		
		Dept dept2 = new Dept();
		dept2.setDeptName("dept1");
		
		Employee emp = new Employee();
		emp.setEmpName("emp1");
		emp.setSalary(20.0);
		emp.setDept(dept);
		
		Employee emp1 = new Employee();
		emp1.setEmpName("emp1");
		emp1.setSalary(20.0);
		emp1.setDept(dept);
		
		Employee emp2 = new Employee();
		emp2.setEmpName("emp1");
		emp2.setSalary(20.0);
		emp2.setDept(dept2);
		
		session.save(emp);
		session.save(emp1);
		session.save(emp2);
		
		session.beginTransaction().commit();
		session.close();
	}
*/
}
