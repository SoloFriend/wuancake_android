package haust.vk.c_session;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(haust.vk.b_second_cache.Dept.class)   
			.addClass(haust.vk.b_second_cache.Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}
	
	@Test
	public void testSession() throws Exception {
		//openSession:  ����Session, ÿ�ζ��ᴴ��һ���µ�session
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		System.out.println(session1 == session2);
		session1.close();
		session2.close();
		
		//getCurrentSession �������߻�ȡsession
		// �̵߳ķ�ʽ����session  
		// һ��Ҫ���ã�<property name="hibernate.current_session_context_class">thread</property>
		Session session3 = sf.getCurrentSession();// ����session���󶨵��߳�
		Session session4 = sf.getCurrentSession();// �ӵ�ǰ�����̻߳�ȡsession
		System.out.println(session3 == session4);
		
		// �ر� �����̷߳�ʽ������session�����Բ��ùرգ� �߳̽���session�Զ��رա�
		//session3.close();
		//session4.close(); ������Ϊͬһ��session�Ѿ��ر��ˣ�
	}
}
