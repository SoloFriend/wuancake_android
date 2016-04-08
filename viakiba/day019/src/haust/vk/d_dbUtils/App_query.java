package haust.vk.d_dbUtils;

import haust.vk.JdbcUtil.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;


public class App_query {
	private Connection conn=null;
	
	//����
	@Test
	public void testUpdate() throws Exception{
		String sql = "delete from admin where id=?";
		// ���Ӷ���
		conn = JdbcUtil.getConnection();

		// ����DbUtils���Ĺ��������
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, 3);
		
		conn.close();
	}
	
	//������
	@Test
	public void testBatch() throws Exception {
		String sql = "insert into admin (userName, pwd) values(?,?)";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		qr.batch(conn, sql, new Object[][]{{"jack1","888"},{"jack2","999"}});
	}
}
