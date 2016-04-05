package cn.itcast.b_batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.itcast.utils.JdbcUtils;

public class AdminDao1 {
	
	private PreparedStatement pstmt=null;
	private Connection conn=null;
	private ResultSet rs=null;
	
	public void save(List<Admin> list){
		
		try {
			conn=JdbcUtils.getConnection();
			
			String sql="INSERT INTO stu(id,name,password) values(?,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			
			int count=9;
			
			for(int i=0;i<list.size() ; i++ ){
				Admin admin=list.get(i);
				pstmt.setInt(1, count+i);
				pstmt.setString(2, admin.getName());
				pstmt.setString(3, admin.getPassword());
				
				//���������
				pstmt.addBatch();
				
				//���ԣ�ÿ����ִ��һ��
				if(i%5 == 0){
					//����ִ��
					pstmt.executeBatch();
					//�������
					pstmt.clearBatch();
				}
				
			}
			
			// ����ִ�� 
			pstmt.executeBatch();
			// ���������
			pstmt.clearBatch();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		
				
		
		
	}
}
