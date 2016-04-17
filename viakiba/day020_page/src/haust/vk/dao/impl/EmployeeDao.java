package haust.vk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.utils.JdbcUtils;
import haust.vk.utils.PageBean;

/**
 * @author vk
 *
 * 2016��4��15��
 */
public class EmployeeDao implements IEmployeeDao{
	/* (non-Javadoc)
	 * @see haust.vk.dao.IEmployeeDao#getAll(haust.vk.utils.PageBean)
	 */
	@Override
	public void getAll(PageBean<Employee> pb) {
		//��ѯ�ܼ�¼����	���õ�pb������
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *            �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
		 */
		// �ж�
		if(pb.getCurrentPage()<=0){
			pb.setCurrentpage(1);
		}else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentpage(pb.getTotalCount());
		}
		
		//1.��ȡ��ǰҳ�������ѯ����ʼ�У����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1)*pb.getPageCount();
		int count=pb.getPageCount();
		
		//��ҳ��ѯ���ݣ��Ѳ�ѯ���������õ�pb������
		String sql="select * from employee limit ?,?";
		
		try {
			QueryRunner qr=new JdbcUtils().getQueryRuner();
			List<Employee> pageData=qr.query(sql, new BeanListHandler<Employee>(Employee.class),index,count);
			pb.setPageData(pageData);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from employee";
		
		try {
			QueryRunner qr=new JdbcUtils().getQueryRuner();
			Long count=qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
