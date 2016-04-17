package haust.vk.a_hello;

import haust.vk.utils.JdbcUtil;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class App {
	
	//ʹ��DBUtil���и���
	@Test
	public void testUpdata() throws Exception{
		String sql="delete from admin where id=3;";
		
		//��������
		Connection con=JdbcUtil.getConnection();
		//�������Ĺ�����
		QueryRunner qr=new QueryRunner();
		//����
		qr.update(con,sql);
		//�ر�
		con.close();
		
	}
	
	//ʹ��DBUtil���в�ѯ
	@Test
	public void testQuery() throws Exception{
		String sql="select * from admin";
		
		//��������
		Connection con=JdbcUtil.getConnection();
		//����������
		QueryRunner qr=new QueryRunner();
		//ִ��sql���
		List<Admin> list=qr.query(con, sql, new BeanListHandler<Admin>(Admin.class));
		System.out.println(list.get(1));
		con.close();
	}
}
