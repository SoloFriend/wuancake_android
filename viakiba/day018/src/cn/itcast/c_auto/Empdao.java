package cn.itcast.c_auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.itcast.utils.JdbcUtils;

public class Empdao {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void save(Employee emp){
		
			
			// ���沿��
			String sql_dept = "insert into dept(deptName) values(?)";
			// ����Ա��
			String sql_emp = "INSERT INTO employee (empName,dept_id) VALUES (?,?)";
			// ����id
			int deptId = 0;
			
			try {
				// ����
				con = JdbcUtils.getConnection();
				
				/*****���沿�ţ���ȡ������*******/
				// ��һ����Ҫָ��������������ǡ�
				pstmt = con.prepareStatement(sql_dept,Statement.RETURN_GENERATED_KEYS);
				// ���ò���
				pstmt.setString(1, emp.getDept().getDeptName());
				// ִ��
				pstmt.executeUpdate();
				
				// ��������ȡ���汣��Ĳ�����������������
				rs =  pstmt.getGeneratedKeys();
				System.out.println();
				// �õ����ص��������ֶ�
				if (rs.next()) {
					deptId = rs.getInt(1);
					System.out.println(deptId);
				}
				
				/*****����Ա��*********/
				pstmt = con.prepareStatement(sql_emp);
				// ���ò���
				pstmt.setString(1, emp.getEmpName());
				pstmt.setInt(2, deptId);
				pstmt.executeUpdate();
				
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			} finally {
				JdbcUtils.close(con, pstmt, rs);
			}
	}
}
