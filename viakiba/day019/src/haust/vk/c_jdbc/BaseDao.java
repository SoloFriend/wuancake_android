package haust.vk.c_jdbc;

import haust.vk.JdbcUtil.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
	//ͨ�õ�dao���Լ�д�����е�dao�����ɴ���
	/*
	 * ���ඨ������������
	 * 1.����
	 * 2.��ѯ
	 */
public class BaseDao {
	
	// ��ʼ������
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	/**
	 * ���µ�ͨ�÷���
	 * @param sql   ���µ�sql���(update/insert/delete)
	 * @param paramsValue  sql�����ռλ����Ӧ��ֵ(���û��ռλ��������null)
	 */
	
	public void update(String sql,Object[] paramsValue){
		try {
			// ��ȡ����
			con=JdbcUtil.getConnection();
			// ����ִ�������stmt����
			pstmt=con.prepareStatement(sql);
			// ����Ԫ���ݣ� �õ�ռλ�������ĸ���
			int count=pstmt.getParameterMetaData().getParameterCount();
			
			if(paramsValue!=null && paramsValue.length>0){
				for(int i=0;i<count;i++){
				pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(pstmt, con, rs);
		}
	}
		/**
		 * ��ѯ��ͨ�÷���
		 * @param sql
		 * @param paramsValue
		 */
		
		public <T> List<T> query(String sql,Object[] paramsValue,Class<T> calzz){
			List<T> list;
			try {
				list = new ArrayList<T>();
				//����
				T t=null;
				
				//��ȡ����
				con=JdbcUtil.getConnection();
				//����stmt����
				pstmt=con.prepareStatement(sql);
				
				int count=pstmt.getParameterMetaData().getParameterCount();
				
				if(paramsValue!=null && paramsValue.length>0){
					for(int i=0;i<count;i++){
						pstmt.setObject(i+1, paramsValue[i]);
					}
				}
				//ִ�в�ѯ
				rs=pstmt.executeQuery();
				//��ȡ�����Ԫ����
				ResultSetMetaData rsmd = rs.getMetaData();
				//---->��ȡ�еĸ���
				int columnCount=rsmd.getColumnCount();
				//����rs
				while(rs.next()){
					//Ҫ��װ�Ķ���
					t=calzz.newInstance();
					//����ÿһ�е�ÿһ���õ�����
					for(int i=0;i<columnCount;i++){
						String columnName=rsmd.getColumnName(i+1);
						Object value=rs.getObject(columnName);
						
						BeanUtils.copyProperty(t, columnName, value);
					}
					list.add(t);	
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JdbcUtil.closeAll(pstmt, con, rs);
			}
	}
	
}
