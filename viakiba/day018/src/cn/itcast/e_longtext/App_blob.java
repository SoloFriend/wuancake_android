package cn.itcast.e_longtext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;


public class App_blob {
	// ȫ�ֲ���
		private Connection con;
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		

		@Test
		// 1. ��������������   ( дlongblob)
		public void testSaveText() {
			String sql = "insert into test(img) values(?)";
			try {
				// ����
				con = JdbcUtils.getConnection();
				// pstmt ����
				pstmt = con.prepareStatement(sql);
				// ��ȡͼƬ��
				InputStream in = App_text.class.getResourceAsStream("7.jpg");
				pstmt.setBinaryStream(1, in);
				
				// ִ�б���ͼƬ
				pstmt.execute();
				
				// �ر�
				in.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.close(con, pstmt, null);
			}
		}
		
		@Test
		// 2. ��ȡ���ı���������   ( ��longblob)
		public void testGetAsText() {
			String sql = "select img from  test where id=1;";
			try {
				// ����
				con = JdbcUtils.getConnection();
				// pstmt ����
				pstmt = con.prepareStatement(sql);
				// ��ȡ
				rs = pstmt.executeQuery();
				if (rs.next()) {
					// ��ȡͼƬ��
					InputStream in = rs.getBinaryStream("img");
					// ͼƬ�����
					FileOutputStream out = new FileOutputStream(new File("e://1.jpg"));
					int len = -1;
					byte b[] = new byte[1024];
					while ((len = in.read(b)) != -1) {
						out.write(b, 0, len);
					}
					// �ر�
					out.close();
					in.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.close(con, pstmt, null);
			}
		}
	
}
