package haust.vk.d_myaop1;

import org.springframework.stereotype.Component;
@Component
public class Aop {
	//�ظ�ִ�еĴ���
	public void begin() {
		System.out.println("��ʼ����");
	}
	public void commit() {
		System.out.println("�ύ��������");
	}
}
