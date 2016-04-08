package haust.vk.d_dbUtils;

import haust.vk.JdbcUtil.JdbcUtil;
import haust.vk.c_jdbc.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

public class App_update {
	private Connection conn=null;
	
	@Test
	public void testQuery() throws Exception {
		String sql="select * from admin where id=?";
		
		conn=JdbcUtil.getConnection();
		//����dbutils���Ĺ��������
		QueryRunner qr=new QueryRunner();
		//��ѯ
		Admin admin=qr.query(conn, sql, new ResultSetHandler<Admin>(){

			@Override
			public Admin handle(ResultSet rs) throws SQLException {
				if(rs.next()){
					Admin admin=new Admin();
					admin.setId(rs.getInt("id"));
					admin.setUserName(rs.getString("userName"));
					admin.setPwd(rs.getString("pwd"));
					
					return admin;
				}
				return null;
			}
		},1 );
		
		System.out.println(admin);
		
		conn.close();
		
	}
	
	
	//��ѯ��ʹ������ṩ�Ľ���������װ����
	
	//1)BeanHandler:��ѯ���ص�������
	
	@Test
	public void testQueryOne() throws Exception {
		String sql="select * from admin where id=?";
		
		conn=JdbcUtil.getConnection();
		//����dbutils���Ĺ��������
		QueryRunner qr=new QueryRunner();
		//��ѯ
		Admin admin=qr.query(conn,sql, new BeanHandler<Admin>(Admin.class), 1);
		
		System.out.println(admin);
		conn.close();
	}
	@Test
	//2)BeanListHandler: ��ѯ����list���ϣ����� Ԫ����ָ���Ķ���
	public void testQueryMany() throws Exception{
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// ��ѯȫ������
		List<Admin> list = qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
		
		System.out.println(list);
		
		conn.close();
	}
	
/*	3) ArrayHandler, ��ѯ���ؽ����¼�ĵ�һ�У���װ�Զ�������, �����أ�Object[]
	4) ArrayListHandler, �Ѳ�ѯ��ÿһ�ж���װΪ�������飬����ӵ�list������
	5) ScalarHandler ��ѯ���ؽ����¼�ĵ�һ�еĵ�һ��  (�ھۺϺ���ͳ�Ƶ�ʱ����)
	6) MapHandler  ��ѯ���ؽ���ĵ�һ����¼��װΪmap*/
	//
	@Test
	public void testArray() throws Exception{
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// ��ѯ
		Map<String, Object> map=qr.query(conn, sql,new MapHandler());
		System.out.println(map.values());
		conn.close();
	}
}
