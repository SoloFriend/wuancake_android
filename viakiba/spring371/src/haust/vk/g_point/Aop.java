package haust.vk.g_point;

import org.aspectj.lang.ProceedingJoinPoint;
//ָ����ǰ��Ϊ������
public class Aop {
	
	//ǰ��֪ͨ  �� ��ִ��Ŀ�귽��֮ǰִ��
	public void begin(){
		System.out.println("��ʼ����/�쳣");
	}
	
	// ����/����֪ͨ����ִ��Ŀ�귽��֮��ִ��  �������Ƿ�����쳣���ն���ִ�С�
	public void after(){
		System.out.println("�ύ����/�ر�");
	}
	
	// ���غ�֪ͨ�� �ڵ���Ŀ�귽��������ִ�� �������쳣��ִ�С�
	public void afterReturning(){
		System.out.println("afterReturning");
	}
	
	// �쳣֪ͨ�� ��Ŀ�귽��ִ���쳣ʱ��ִ�д˹�ע�����
	public void afterThrowing(){
		System.out.println("AfterThrowing");
	}
	
	// ����֪ͨ������Ŀ�귽ʽִ��
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("����ǰ");
		
		pjp.proceed();
		
		System.out.println("���ƺ�");
	}
}
