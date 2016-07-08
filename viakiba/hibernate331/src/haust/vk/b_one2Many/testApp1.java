package haust.vk.b_one2Many;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class testApp1 {
	private static SessionFactory sf ;
	
	static{
		sf=new Configuration()
			   .configure()
			   .addClass(Dept.class)
			   .addClass(Employee.class)
			   .buildSessionFactory();
	}
	
	
	//���� ���ŷ�   һ��һ�ķ�ʽ
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//��������
		//����
		Dept dept = new Dept();
		dept.setDeptName("Dept1");
		//ְԱ
		Employee empz = new Employee();
		empz.setEmpName("zEmp");
		
		Employee empl = new Employee();
		empl.setEmpName("lEmp");
		
		//��ϵ����
		dept.getEmps().add(empl);
		dept.getEmps().add(empz);
		
		//����
		session.save(empl);
		session.save(dept);
		session.save(empz);
		
		tx.commit();
		session.close();
		
		/**
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
			Hibernate: insert into t_dept (deptName) values (?)
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
			Hibernate: update t_employee set dept_id=? where empId=?
			Hibernate: update t_employee set dept_id=? where empId=?
		 */
	}
	
	// ���� Ա����  ���һ  �Ƽ�
	@Test
	public void testSave2() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//��������
		Dept dept = new Dept();
		dept.setDeptName("dept2");
		
		//����
		Employee emp_zs = new Employee();
		emp_zs.setEmpName("����");
		Employee emp_ls = new Employee();
		emp_ls.setEmpName("����");
		// ��ϵ
		emp_ls.setDept(dept);
		emp_zs.setDept(dept);
		
		session.save(dept);
		session.save(emp_ls);
		session.save(emp_zs);
		
		tx.commit();
		session.close();
		
		/*
			Hibernate: insert into t_dept (deptName) values (?)
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
		*/
	}
}
