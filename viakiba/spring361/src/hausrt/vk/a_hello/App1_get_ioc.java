package hausrt.vk.a_hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App1_get_ioc {
	//1.ͨ��������õ�IOC���������Ķ���
	@Test
	public void testIOC() throws Exception {
		//��������
		User user1 = new User();
		
		// ���ڣ��Ѷ���Ĵ�������spring��IOC����
		Resource resource = new ClassPathResource("haust/vk/a_hello/applicationContext.xml");
		
		// ������������(Bean�Ĺ���), IOC���� = ������ + applicationContext.xml
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//
		User user =(User) factory.getBean("user");
		
		System.out.println(user.getId());
	}
	
	//�����㣩ֱ�ӵõ�IOC��������
	@Test
	public void testAc() throws Exception {
		//�õ�IOC��������
		ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/a_hello/applicationContext");
		
		//�������л�ȡbean
		User user =(User) ac.getBean("user");
		System.out.println(user);
	}
}
