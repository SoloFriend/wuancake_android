package haust.vk.d_c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class App {
	@Test
	//Ӳ����ʵ��c3p0�����ӳع���
	public void test1() throws Exception{
		//�������ӳع�����
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_demo");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setMaxIdleTime(1000);
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		
		Connection con=dataSource.getConnection();
		con.prepareStatement("insert into admin values(1,'lisi','546454') ").executeUpdate();
		con.close();
	}
	
	//ʹ�������ļ�xml���г�ʼ������
	@Test
	public void testXml() throws Exception{
		// ����c3p0���ӳغ��Ĺ�����
		// �Զ�����src��c3p0�������ļ���c3p0-config.xml��
		ComboPooledDataSource datasource=new ComboPooledDataSource();
		PreparedStatement pstmt=null;
		Connection con=datasource.getConnection();
		for (int i=1; i<11;i++){
			String sql = "insert into employee(empName,dept_id) values(?,?)";
			// ִ�и���
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Rose" + i);
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
		}
		pstmt.close();
		// �ر�
		con.close();
	}
}
