package cn.itcast.d_tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;



public class AccountDao {
	
	// ȫ�ֲ���
		private Connection con;
		private PreparedStatement pstmt;
		private int count=0;
	/*
	 * ��ʹ������
	 */
	
		@Test
		public void trans2(){
			String sql_zs = "UPDATE account set money=money-1000 where accountName='����';";
			String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='����';";
			
			try {
				con=JdbcUtils.getConnection();
				pstmt=con.prepareStatement(sql_zs);
				
				count=pstmt.executeUpdate();
				System.out.println("Ӱ��һ��");
				pstmt=con.prepareStatement(sql_ls);
				count=pstmt.executeUpdate();
				System.out.println("Ӱ��һ��");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JdbcUtils.close(con, pstmt);
			}
		}
		
	/*
	 * ʹ����ʽ����
	 */
	@Test
	public void trans1(){
		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='����';";
		String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='����1';";

		try {
			con = JdbcUtils.getConnection(); // Ĭ�Ͽ�������ʿ����
			con.setAutoCommit(true);

			/*** ��һ��ִ��SQL ***/
			pstmt = con.prepareStatement(sql_zs);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
			/*** �ڶ���ִ��SQL ***/
			pstmt = con.prepareStatement(sql_ls);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
		} catch (Exception e) {
			try {
				// ���� �����쳣����Ҫ�ع�����
				con.rollback();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				// �������еĲ���ִ�гɹ�, �ύ����
				con.commit();
				JdbcUtils.close(con, pstmt, null);
			} catch (SQLException e) {
			}
		}
	}
	
	/*
	 * ʹ����ʽ����
	 */
	@Test
	public void trans(){
		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='����';";
		String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='����1';";
		Savepoint sp=null;
		try {
			con = JdbcUtils.getConnection(); // Ĭ�Ͽ�������ʿ����
			con.setAutoCommit(false);

			/*** ��һ��ִ��SQL ***/
			pstmt = con.prepareStatement(sql_zs);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
			
			sp=con.setSavepoint();
			/*** �ڶ���ִ��SQL ***/
			pstmt = con.prepareStatement(sql_ls);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
		} catch (Exception e) {
			try {
				// ���� �����쳣����Ҫ�ع�����
				con.rollback(sp);
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				// �������еĲ���ִ�гɹ�, �ύ����
				con.commit();
			} catch (SQLException e) {
			}
			JdbcUtils.close(con, pstmt, null);
		}
	}
}
