package haust.vk.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static{
		sf = new Configuration()
				 .configure()
				 .buildSessionFactory();
	}
	
	public static Session getSf(){
		// �̵߳ķ�ʽ����session������Ҫ����
		// ���Բ��ùرգ����Զ��ء�
		return sf.getCurrentSession();
	}
}
