package haust.vk.b_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �����е�dao����������󡾶�̬����
 * ������󣬲���Ҫʵ�ֽӿ�
 */
public class ProxyFactory {
	private Object target;

	public ProxyFactory(Object target) {
		super();
		this.target = target;
	}
	
	public Object getProxyInstance() {
		
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("�������񡣡�����");
						
						//ִ��Ŀ�����
						Object returnValue = method.invoke(target, args);
						
						System.out.println("�ύ���񡣡�����");
						
						return returnValue;
					}
				});
	}
}
