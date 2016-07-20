package haust.vk.e_aop_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//ָ����ǰ��Ϊ������
@Aspect
@Component
public class Aop {
	
	//ָ������� ��ʽ��������Щ��������Ϊ��Щ�����ɴ������
	//���� ��ʾ����haust.vk.e_aop_anno���µ������༰������public����
	//�����
	@Pointcut("execution(* haust.vk.e_aop_anno.*.*(..))")
	public void pointCut_(){
		
	}
	//ǰ��֪ͨ  �� ��ִ��Ŀ�귽��֮ǰִ��
	@Before("pointCut_()")
	public void begin(){
		System.out.println("��ʼ����/�쳣");
	}
	
	// ����/����֪ͨ����ִ��Ŀ�귽��֮��ִ��  �������Ƿ�����쳣���ն���ִ�С�
	@After("pointCut_()")
	public void after(){
		System.out.println("�ύ����/�ر�");
	}
	
	// ���غ�֪ͨ�� �ڵ���Ŀ�귽��������ִ�� �������쳣��ִ�С�
	@AfterReturning("pointCut_()")
	public void afterReturning(){
		System.out.println("afterReturning");
	}
	
	// �쳣֪ͨ�� ��Ŀ�귽��ִ���쳣ʱ��ִ�д˹�ע�����
	@AfterThrowing("pointCut_()")
	public void afterThrowing(){
		System.out.println("AfterThrowing");
	}
	
	// ����֪ͨ������Ŀ�귽ʽִ��
	@Around("pointCut_()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("����ǰ");
		
		pjp.proceed();
		
		System.out.println("���ƺ�");
	}
}
