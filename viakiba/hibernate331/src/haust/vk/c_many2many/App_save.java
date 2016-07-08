package haust.vk.c_many2many;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class App_save {
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Project.class)   
			.addClass(Developer.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}
	
	// 1. ��Զ࣬����  ��ֻ��ͨ��һ��ά������һ���������ظ�ά������
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ������Ŀ����
		Project prj_ds = new Project();
		prj_ds.setPrj_name("����ϵͳ");
		Project prj_oa = new Project();
		prj_oa.setPrj_name("OAϵͳ");
				
		// ����Ա������
		Developer dev_cj = new Developer();
		dev_cj.setD_name("�ܼ�");
		Developer dev_wc = new Developer();
		dev_wc.setD_name("����");
		Developer dev_lz = new Developer();
		dev_lz.setD_name("����");
		// ��ϵ ����Ŀ����
		prj_ds.getDevelopers().add(dev_cj);
		prj_ds.getDevelopers().add(dev_wc); // ����ϵͳ���ܼ���������
		prj_oa.getDevelopers().add(dev_wc);
		prj_oa.getDevelopers().add(dev_lz); // OAϵͳ�����������ţ�
		
		session.save(prj_ds);
		session.save(prj_oa);   // ����Ҫ���ü������� 
		
		session.getTransaction().commit();
		session.close();
	}
}
