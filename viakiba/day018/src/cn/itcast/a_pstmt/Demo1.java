package cn.itcast.a_pstmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;

public class Demo1 {
	/*
	 * ���Ƕ�sqlע���һ����ϰ������Ҳ���й�ѧϰ
	 * statement�޷�������Ч�ı���sqlע��
	 * ���Ǿ���Ԥ���빦�ܵ�preparedstatement
	 * ������Ч�ķ���sqlע��ĳ���
	 */
	
	
	/*
	 * ��������ȫ�ֱ���
	 */
	private Connection conn=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private CallableStatement cstmt=null;
	
	
	
	/*
	 * ����ʹ��statement����sqlע���ģ�⣨��½��
	 */
	@Test
	public void test1(){
		try {
			conn=JdbcUtils.getConnection();
			
			String user="lisi";
			String password=" ' or 1=1 -- ";
			
			//String sql="select * from stu where name='"+user+"' and password='"+password+"' ";
			String sql="select * from stu where name='lisi' and password=' ' or 1=1 -- ' ";
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			if(rs!=null){
				rs.next();
				System.out.println(rs.getString("name"));
				System.out.println("��½�ɹ�");
			}else{
				System.out.println("��½ʧ��");
			}
			
			
			//System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.close(conn, stmt,rs);
		}
	}
	
	/*
	 * ����ʹ��PreparedStatement��ֹsqlע���ģ�⣨��½��
	 */
	@Test
	public void test2(){
		try {
			conn=JdbcUtils.getConnection();
			
			String user="lisi";
			String password=" ' or 1=1 -- ";
			
			String sql="select * from stu where name=? and password=?";
			//String sql="select * from stu where name='lisi' and password=' ' or 1=1 -- ' ";
							
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("��½�ɹ�"+rs.getInt("id"));
			}else{
				System.out.println("��½ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.close(conn, stmt,rs);
		}
		
		
		
	}
}
