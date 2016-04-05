package cn.itcast.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/*
 * ����һ�����������ڳ�ʼ��connection����
 * �ر����ӣ�rs��conn��stmt��pstmt��
 */

public class JdbcUtils {
	/*
	 * ʹ��  static ��ʹ��ʱ����ִ��static������ 
	 */
	private static String url=null;
	private static String user=null;
	private static String password=null;
	
	
	static {
		try {
			/*
			 * ע������
			 */
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static Connection getConnection(){
		try {
			Properties pr=new Properties();
			FileInputStream file=new FileInputStream("./src/db.properties");
			pr.load(file);
			
			url=pr.getProperty("url");
			user=pr.getProperty("user");
			password=pr.getProperty("password");		
			
			Connection conn=DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void close(Connection conn,Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		
	}

	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		
	}
}
