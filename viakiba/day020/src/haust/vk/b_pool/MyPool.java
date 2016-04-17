package haust.vk.b_pool;

import haust.vk.utils.JdbcUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


/**
 * �Զ������ӳ�, ��������
 * ����ʵ�֣�
	1.  MyPool.java  ���ӳ��࣬   
	2.  ָ��ȫ�ֲ�����  ��ʼ����Ŀ���������������ǰ���ӡ�   ���ӳؼ���
	3.  ���캯����ѭ������3������
	4.  дһ���������ӵķ���
	5.  ��ȡ����
	------>  �жϣ� ���������ӣ� ֱ����
	 ------>                ����û�����ӣ�
	------>                 �жϣ��Ƿ�ﵽ����������� �ﵽ���׳��쳣��û�дﵽ�����������
			�����µ�����
	6. �ͷ�����
	 ------->  ���ӷŻؼ�����(..)
 *
 */


public class MyPool {
	private int init_count=3;//��ʼ��������Ŀ
	private int max_count=6;//���������
	private int current_count=0;//��ǰ������
	//���ӳؼ���
	private LinkedList<Connection> pool=new LinkedList<Connection>();
	
	//���캯������ʼ�����ӷ������ӳ�
	public MyPool(){
		for(int i=0;i<current_count;i++){
			Connection con=JdbcUtil.getConnection();
			pool.addLast(con);
			current_count++;
		}
	}
	
	//����һ���µ����ӷ���
	private Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			final Connection con=DriverManager.getConnection("jdbc:mysql:///jdbc_demo", "root", "root");
			
			//��con�Ķ���Ĵ���
			Connection proxy=(Connection) Proxy.newProxyInstance(
					con.getClass().getClassLoader(),//�������
					new Class[]{Connection.class}, //Ŀ�����ʵ�ֵĽӿ�����
					new InvocationHandler() {
						//�¼�����������
						@Override
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							//��������ֵ
							Object result=null;
							//��ȡ��������
							String methodName = method.getName();
							
							//����ƥ�䣬��ִ��
							if("close".equals(methodName)){
								System.out.println("begin:ִ��close");
								pool.addLast(con);
								current_count--;
								System.out.println("end:�������");
							}else{//��ƥ�䣬ִ��Ĭ�ϵķ���
								result=method.invoke(con, args);
							}
							//���ط�������ֵ
							return result;
						}
					}
				);
			//�������¼������Ļ����򷵻�Ĭ�ϵ�
		return proxy;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//��ȡ����
	public Connection getConnection(){
		
		if(pool.size()>0){
			//���ӳػ���ʣ�����ӣ�ȡ������Connection����
			return pool.removeFirst();
		}
		//���ӳ��������þ������û�дﵽ������������򴴽�����
		if(current_count<max_count){
			
			current_count++;
			
			return createConnection();
		}
		// �����ǰ�Ѿ��ﵽ������������׳��쳣
		throw new RuntimeException("��ǰ�������ﵽ���");
	}
	
	//�ͷ�����
	public void realeaseConnection(Connection con){
		//����ص���Ŀ���С�ڳ�ʼ�����ӣ��ͷ������
		if(pool.size()<init_count){
			pool.addLast(con);
		}else{
			//�ر�
			try {
				current_count--;
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyPool pool=new MyPool();
		System.out.println("��ǰ��������"+pool.current_count);
		
		//ʹ������
		//pool.getConnection();
		pool.getConnection();
		Connection con5=pool.getConnection();
		Connection con4=pool.getConnection();
		Connection con3=pool.getConnection();
		Connection con2=pool.getConnection();
		Connection con1=pool.getConnection();
		// �ͷ�����, ���ӷŻ����ӳ�
		//pool.realeaseConnection(con1);
		/*
		 * ϣ�������ر����ӵ�ʱ��Ҫ�����ӷ������ӳأ���������Connection�ӿڵ�close����ʱ��ϣ������pool.addLast(con);������
		 * 																			�����ӷ������ӳ�
		 * ���1��ʵ��Connection�ӿڣ���дclose����
		 * ���2����̬����
		 */
		con5.close();
		//con4.close();
		System.out.println("���ӳ�"+pool.pool.size());
		System.out.println("��ǰ����"+pool.current_count);
	}
}
