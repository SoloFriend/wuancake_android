package haust.vk.b_metadata;

import haust.vk.JdbcUtil.JdbcUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

public class App {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	//���ݿ�Ԫ����
	@Test
	public void test1(){
		conn=JdbcUtil.getConnection();
		
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
			System.out.println(metaData.getDatabaseProductName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2. ����Ԫ����
	@Test
	public void test2() {
		try {
			conn=JdbcUtil.getConnection();
			
			String sql="select * from test1 where id=?;";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, 2);
			//�õ�����Ԫ���ݵĻ�ȡ����
			ParameterMetaData p_metaData =	pstmt.getParameterMetaData();
			//��ȡ����Ԫ���ݵĸ���
			int count=p_metaData.getParameterCount();
			//����
			System.out.println(count);
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(null, conn, null);
		}
	}
	
	//��ȡ�����Ķ�Ӧֵ
	@Test
	public void test3(){
		try {
			conn=JdbcUtil.getConnection();
			String sql="select * from test1 where id=?;";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, 2);
			rs=pstmt.executeQuery();
			
			ResultSetMetaData rs_metaData = rs.getMetaData();
			
			while(rs.next()){
				int count = rs_metaData.getColumnCount();
				
				for(int i=0;i<count;i++){
					
					String id=rs_metaData.getColumnName(i+1);
					Object value=rs.getObject(id);
					
					System.out.println(id+"="+value);
				}
				System.out.println("���� ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(null, conn, rs);
		}
	}
}
