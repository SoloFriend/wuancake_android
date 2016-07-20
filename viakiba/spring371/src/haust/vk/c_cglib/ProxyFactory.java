package haust.vk.c_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Cglib���������
 * (��UserDao ���ڴ��ж�̬����һ���������)
 */
public class ProxyFactory implements MethodInterceptor{
	private Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	//��Ŀ����󴴽��������
	public Object getProxyInstance() {
		//1.���ù�����
		Enhancer enhancer = new Enhancer();
		//2.���ø���
		enhancer.setSuperclass(target.getClass());
		//3.���ûص�����
		enhancer.setCallback(this);
		//4.�������ࣨ�������
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("��ʼ���񡣡���");
		
		//ִ��Ŀ�����ķ���
		Object returnValue = method.invoke(target, args);
		
		System.out.println("�ύ���񡣡�����");
		
		return returnValue;
	}
	
}
