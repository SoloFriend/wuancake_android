package haust.vk.dao;

import haust.vk.entity.Dept;

import org.hibernate.SessionFactory;

//���ݷ��ʲ�
public class DeptDao {
	private SessionFactory sessionFactory;
	// Spring��Hibernate���ϣ� IOC����ע��
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	// ����һ����¼
	// Spring��Hibernate���ϣ����������Spring
	public void save(Dept dept) {
		sessionFactory.getCurrentSession().save(dept);
	}
}
